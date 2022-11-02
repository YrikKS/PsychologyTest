package ru.kurgin.psychologyTest

import ru.kurgin.psychologyTest.testMainActivity.realizationQuestion.GroupsAnswer
import java.io.File

object ParserFromFile {
    private val allFileList = File("src\\main\\resources\\question.txt").readLines()

    val countGroups: Int
    val countQuestions: Int

    init {
        val regexForParameters = Regex(Constants.REGEX_FOR_PARAMETRS)
        val resultParameters = regexForParameters.find(allFileList[0])
        countQuestions = resultParameters?.groups?.get(1)?.value?.toInt()!!
        countGroups = resultParameters.groups[2]?.value?.toInt()!!
    }

    var listGroupAnswer: List<GroupsAnswer> = ArrayList<GroupsAnswer>()
        get() = field.toList()

    init {
        val regexForParameters = Regex(Constants.REGEX_FOR_GROUP)
        for (index in 1..countGroups) {
            val resultParameters = regexForParameters.find(allFileList[index])
            listGroupAnswer += resultParameters?.groups?.let {
                GroupsAnswer(
                    it[1]?.value!!,

                    (if (it[2]?.value?.isEmpty() == true) {
                        listOf()
                    } else {
                        it[2]?.value?.split(", ")?.map { element -> element.trim().toInt() }
                    }) as List<Int>,

                    (if (it[3]?.value?.isEmpty() == true) {
                        listOf()
                    } else {
                        it[3]?.value?.split(", ")?.map { element -> element.trim().toInt() }
                    }) as List<Int>,
                )
            }!!
        }
        listGroupAnswer.forEach { it.apply(::println) }
    }

    var listQuestionAndAnswer: List<String> = ArrayList()
        get() = field.toList()

    init {
        val regexForParameters = Regex(Constants.REGEX_FOR_QUESTION)
        for (index in (countGroups + 1) until countQuestions + countGroups + 1) {
            val resultParameters = regexForParameters.find(allFileList[index])
            listQuestionAndAnswer += resultParameters?.groups?.get(2)?.value!!
        }
    }

}