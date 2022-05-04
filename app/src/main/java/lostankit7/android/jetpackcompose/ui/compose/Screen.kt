package lostankit7.android.jetpackcompose.ui.compose

enum class Screen(val route: String) {
    MainScreen("main_screen"),
    DetailScreen("detail_screen");

    fun withArgs(vararg args: String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}