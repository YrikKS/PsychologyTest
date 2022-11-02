package ru.kurgin.psychologyTest.testMainActivity.realizationQuestion

import ru.kurgin.psychologyTest.Constants

class QuestionCollection(questionsFromFile: List<String>, whichStart: Int = 0, countQuestions: Int = 0) {
    var countCategories: Int = 0
    private var countQuestion: Int = countQuestions

//    private var questionWithAnswer = HashMap<Int, Pair<String, Answer>>()

    init {
        val regex = Regex(Constants.REGEX_FOR_QUESTION)
        for (index in 0..20) {
            val result = regex.find(questionsFromFile[index])
            println(questionsFromFile[index])
            println("number question = ${result?.groups?.get(0)}")
            println("question = ${result?.groups?.get(1)} \n")
//            if (result != null) {
//                questionWithAnswer += result?.groups?.get(0) to Pair(result?.groups?.get(1) to Answer(false))
//            }
        }
    }

    fun getQuestion(numberQuestion: Int): QuestionAndAnswer {
        TODO("Not yet implemented")
    }

    fun setAnswer() {
        TODO("Not yet implemented")
    }

}