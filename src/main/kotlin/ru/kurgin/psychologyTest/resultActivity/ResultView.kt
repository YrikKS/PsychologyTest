package ru.kurgin.psychologyTest.resultActivity

import javafx.scene.Parent
import javafx.scene.chart.BarChart
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import ru.kurgin.psychologyTest.ParserFromFile
import tornadofx.*

class ResultView : View("Тест") {
    override val root: BorderPane by fxml("/resultWindow.fxml")
    private val resultGraphics: BarChart<Int, Int> by fxid("resultGraphics")

    //    init{
//        resultGraphics.apply {
//            val list = ParserFromFile.listGroupAnswer
//            list.map{
//                series(it.nameGroup) {
//
//                }
//            }
//        }
//    }
//    var str: String by param()
//    init {
//        str = (params["list"] as? String).toString()
//        println(str)
//    }
}