package com.example.assignment1.data

object BookRepository {

    private val books = listOf(
        Book("b1", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, "A novel about the American dream, wealth, and love during the Roaring Twenties."),
        Book("b2", "To Kill a Mockingbird", "Harper Lee", "Classic", 1960, "A story addressing serious issues like racial injustice and moral growth through the eyes of a child."),
        Book("b3", "Dune", "Frank Herbert", "Sci-Fi", 1965, "An epic science fiction novel set in a distant future amidst a feudal interstellar society."),
        Book("b4", "Foundation", "Isaac Asimov", "Sci-Fi", 1951, "The first book in the Foundation Series, dealing with psychohistory and the fall of a galactic empire."),
        Book("b5", "Pride and Prejudice", "Jane Austen", "Romance", 1813, "A romantic novel that charts the emotional development of the protagonist, Elizabeth Bennet."),
        Book("b6", "The Notebook", "Nicholas Sparks", "Romance", 1996, "A contemporary love story set in post-World War II North Carolina."),
        Book("b7", "The Catcher in the Rye", "J.D. Salinger", "Classic", 1951, "Now this one is a reeeeeaaaal doozy innit"),
        Book("b8", "Harry Potter", "J.K. Rowling", "Classic", 1997, "This is a true classic imo fr fr"),
        Book("b9", "Yellow Submarine", "The Beatles", "Classic", 1966, "This isn't even a book! It's a classic though!"),
        Book("b10", "The Hobbit", "J.R.R. Tolkien", "Classic", 1937, "This is a classic!"),
        Book("b11", "The Alchemist", "Paulo Coelho", "Classic", 1988, "This is a classic"),
        Book("b12", "The Da Vinci Code", "Dan Brown", "Classic", 2003, "This is actually a pretty terrible book"),
        Book("b13", "The Very Hungry Caterpillar", "Eric Carle", "Classic", 1969, "This is a classic"),
    )

    fun getAllGenres(): List<String> {
        return books.map { it.genre }.distinct().sorted()
    }

    fun getBooksByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, ignoreCase = true) }
    }

    fun getBookById(id: String): Book? {
        return books.find { it.id == id }
    }
}