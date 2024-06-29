abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        val pi = 3.141592653589793
        return pi * radius * radius
    }

    override fun perimeter(): Double {
        val pi = 3.141592653589793
        return 2 * pi * radius
    }
}

fun main() {
    val rectangle: Shape = Rectangle(5.0, 3.0)
    val circle: Shape = Circle(4.0)
    
    println("Rectangle:")
    println("Area: ${rectangle.area()}")
    println("Perimeter: ${rectangle.perimeter()}")
    println()
    
    println("Circle:")
    println("Area: ${circle.area()}")
    println("Perimeter: ${circle.perimeter()}")
    println()
}
/*
Ouptut:
Rectangle:
Area: 15.0
Perimeter: 16.0

Circle:
Area: 50.26548245743669
Perimeter: 25.132741228718345
*/