package com.example.amilimetros.navigation

// Clase sellada para rutas: evita "strings mágicos" y facilita refactors
sealed class Route(val path: String) {
    data object Home : Route("home")
    data object Login : Route("login")
    data object Register : Route("register")
    data object Products : Route("products")
    data object Cart : Route("cart")
    data object Animals : Route("animals")
    data object Admin : Route("admin")
}