from flask import Flask, render_template, request, jsonify, redirect, url_for
import sqlite3
import os

app = Flask(__name__)

# Initialize Database
def init_db():
    if not os.path.exists('database'):
        os.makedirs('database')
    conn = sqlite3.connect('database/tickets.db')
    cursor = conn.cursor()
    cursor.execute('''
    CREATE TABLE IF NOT EXISTS tickets (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        user TEXT NOT NULL,
        place TEXT NOT NULL,
        visit_time TEXT NOT NULL,
        booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )
    ''')
    conn.commit()
    conn.close()

# Sample Data
PLACES = ['Museum of Natural History', 'Art Gallery', 'Science Center', 'Zoo']
SELECTED_PLACE = ""

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/book_ticket', methods=['GET', 'POST'])
def book_ticket():
    global SELECTED_PLACE
    if request.method == 'POST':
        place = request.form.get('place')
        time = request.form.get('time')

        conn = sqlite3.connect('database/tickets.db')
        cursor = conn.cursor()
        cursor.execute('INSERT INTO tickets (user, place, visit_time) VALUES (?, ?, ?)', ('User1', place, time))
        conn.commit()
        conn.close()

        return redirect(url_for('view_tickets'))
    
    return render_template('book_ticket.html', places=PLACES)

@app.route('/view_tickets')
def view_tickets():
    conn = sqlite3.connect('database/tickets.db')
    cursor = conn.cursor()
    cursor.execute('SELECT * FROM tickets WHERE user=?', ('User1',))
    tickets = cursor.fetchall()
    conn.close()
    
    return render_template('view_tickets.html', tickets=tickets)

@app.route('/api/chat', methods=['POST'])
def chat():
    global SELECTED_PLACE
    user_message = request.json.get('message')
    response = nlp_response(user_message)
    return jsonify(response)

def nlp_response(message):
    global SELECTED_PLACE
    message = message.lower()
    
    if "book ticket" in message:
        return {"text": "Which place would you like to book a ticket for?", "options": PLACES}
    
    elif any(place.lower() in message for place in PLACES):
        SELECTED_PLACE = next((place for place in PLACES if place.lower() in message), None)
        if SELECTED_PLACE:
            return {"text": f"You have selected {SELECTED_PLACE}. Please select a time for your visit.", "options": ["10:00 AM", "2:00 PM", "5:00 PM"]}
    
    elif any(time in message for time in ["10:00 am", "2:00 pm", "5:00 pm"]):
        conn = sqlite3.connect('database/tickets.db')
        cursor = conn.cursor()
        cursor.execute('INSERT INTO tickets (user, place, visit_time) VALUES (?, ?, ?)', ('User1', SELECTED_PLACE, message))
        conn.commit()
        conn.close()
        return {"text": "Your ticket has been booked successfully! You can view your tickets from the main menu."}
    
    elif "view tickets" in message:
        conn = sqlite3.connect('database/tickets.db')
        cursor = conn.cursor()
        cursor.execute('SELECT * FROM tickets WHERE user=?', ('User1',))
        tickets = cursor.fetchall()
        conn.close()
        
        ticket_messages = [f"ID: {ticket[0]}, Place: {ticket[2]}, Time: {ticket[3]}, Booked At: {ticket[4]}" for ticket in tickets]
        if not ticket_messages:
            return {"text": "You have no booked tickets."}
        else:
            return {"text": "Here are your booked tickets:\n" + "\n".join(ticket_messages)}
    
    else:
        return {"text": "I'm not sure I understand. Please choose an option: 'Book Ticket' or 'View Tickets'."}

if __name__ == '__main__':
    init_db()
    app.run(debug=True)
