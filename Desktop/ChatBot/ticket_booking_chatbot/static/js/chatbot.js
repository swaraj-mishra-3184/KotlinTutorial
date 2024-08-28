document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('userInput').addEventListener('keypress', function (e) {
        if (e.key === 'Enter') {
            sendMessage();
        }
    });
});

function sendMessage() {
    const userMessage = document.getElementById('userInput').value;
    if (!userMessage) return;

    const chatbox = document.getElementById('chatbox');
    const userMessageElement = document.createElement('div');
    userMessageElement.className = 'user-message';
    userMessageElement.textContent = userMessage;
    chatbox.appendChild(userMessageElement);

    document.getElementById('userInput').value = '';

    fetch('/api/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ message: userMessage })
    })
    .then(response => response.json())
    .then(data => {
        const botMessageElement = document.createElement('div');
        botMessageElement.className = 'bot-message';
        botMessageElement.textContent = data.text;
        chatbox.appendChild(botMessageElement);

        if (data.options) {
            const optionsContainer = document.createElement('div');
            optionsContainer.className = 'options';
            data.options.forEach(option => {
                const button = document.createElement('button');
                button.textContent = option;
                button.onclick = () => {
                    document.getElementById('userInput').value = option;
                    sendMessage();
                };
                optionsContainer.appendChild(button);
            });
            chatbox.appendChild(optionsContainer);
        }

        chatbox.scrollTop = chatbox.scrollHeight; // Scroll to bottom
    })
    .catch(error => console.error('Error:', error));
}
