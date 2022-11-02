package ru.kurgin.psychologyTest.testMainActivity

import javafx.scene.control.Button
import javafx.scene.control.ProgressIndicator
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import ru.kurgin.psychologyTest.ParserFromFile
import ru.kurgin.psychologyTest.menuActivity.MainMenu
import ru.kurgin.psychologyTest.resultActivity.ResultView
import tornadofx.*

class TestView : View("Test") {
    private val model = ModelMainActivity()

    override val root: BorderPane by fxml("/mainWindow.fxml")
    private val textQuestion: TextArea by fxid("textQuestion")
    private val informationTextField: TextArea by fxid("informationTextField")

    private val progressIndicator: ProgressIndicator by fxid("progressIndicator")

    override fun onDock() {
        model.initializeModel()
        informationTextField.text = "Вопрос ${model.currentQuestion + 1} из ${ParserFromFile.countQuestions}"
        progressIndicator.progress = model.currentQuestion.toDouble() / ParserFromFile.countQuestions
        textQuestion.text = model.getQuestion()
    }

    private fun nextQuestion() {
        model.nextQuestion()
        textQuestion.text = model.getQuestion()
        informationTextField.text = "Вопрос ${model.currentQuestion + 1} из ${ParserFromFile.countQuestions}"
        progressIndicator.progress = model.currentQuestion.toDouble() / ParserFromFile.countQuestions
    }

    private val exitButton: Button by fxid("exitButton")

    init {
        exitButton.apply {
            action {
//                find<ResultView>(mapOf("asd" to "list")).openWindow()
                replaceWith(MainMenu::class)
            }
        }
    }

    private val buttonRight: Button by fxid("buttonRight")
    private val buttonIncorrect: Button by fxid("buttonIncorrect")

    init {
        buttonRight.apply {
            action {
                model.setCorrect()
                nextQuestion()
            }
        }

        buttonIncorrect.apply {
            action {
                model.setNotCorrect()
                nextQuestion()
            }
        }
    }

}