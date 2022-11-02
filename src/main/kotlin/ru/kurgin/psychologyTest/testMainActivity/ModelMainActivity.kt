package ru.kurgin.psychologyTest.testMainActivity

import ru.kurgin.psychologyTest.ParserFromFile
import ru.kurgin.psychologyTest.testMainActivity.realizationQuestion.AnswerOptions
import ru.kurgin.psychologyTest.testMainActivity.realizationQuestion.QuestionAndAnswer

class ModelMainActivity {
    val listQuestionAndAnswer: List<QuestionAndAnswer> =
        ParserFromFile.listQuestionAndAnswer.map { QuestionAndAnswer(it, AnswerOptions.NO_ANSWER) }

    var currentQuestion = 0
        private set(value) {
            field = value
        }

    init {
        listQuestionAndAnswer.map(::println)
    }

    fun initializeModel() {
        listQuestionAndAnswer.forEach { it.answer = AnswerOptions.NO_ANSWER }
        currentQuestion = 0
    }

    fun setCorrect() {
        listQuestionAndAnswer[currentQuestion].answer = AnswerOptions.CORRECT
    }

    fun setNotCorrect() {
        listQuestionAndAnswer[currentQuestion].answer = AnswerOptions.NOT_CORRECT
    }

    fun getQuestion() = listQuestionAndAnswer[currentQuestion].question

    fun nextQuestion() {
        if (listQuestionAndAnswer.size - 1 <= currentQuestion) {
            println("last Question")
        } else {
            currentQuestion++
        }
    }
}