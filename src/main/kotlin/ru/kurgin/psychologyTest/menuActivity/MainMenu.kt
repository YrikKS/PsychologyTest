package ru.kurgin.psychologyTest.menuActivity

import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import ru.kurgin.psychologyTest.testMainActivity.TestView
import tornadofx.*
import kotlin.system.exitProcess

class MainMenu : View("Тест") {
    override val root: BorderPane by fxml("/mainXml.fxml")
    override fun onDock() {
        println("Docking MyView1!")
    }

    override fun onUndock() {
        println("Undocking MyView1!")
    }

    init {
        root.apply {

        }
    }

    private val startButton: Button by fxid("startTest")
    private val viewResult: Button by fxid("viewResult")
    private val exitButton: Button by fxid("exitButton")

    init {
        startButton.apply {
            action {
                replaceWith<TestView>()
            }
        }
        viewResult.apply {
            action {
                println("view result")
            }
        }
        exitButton.apply {
            action {
                exitProcess(0)
            }
        }
    }

//    override val root = vbox {
//        setMinSize(720.0, 560.0)
//
//        button("Press Me") {
//            action {
//                check++
//                println(check)
////                find<MyView1>(mapOf("check" to check)).openWindow()
//                replaceWith(
//                    MyView1::class,
//                    ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
//            }
//        }
//        label("check.toString()") {
//            addClass(Styles.heading)
//        }
//    }
}
