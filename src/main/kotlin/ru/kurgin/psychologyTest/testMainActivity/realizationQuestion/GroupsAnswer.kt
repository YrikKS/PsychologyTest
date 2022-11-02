package ru.kurgin.psychologyTest.testMainActivity.realizationQuestion

data class GroupsAnswer(
    val nameGroup: String,
    val correctAnswerList: List<Int>,
    val uncorrectedAnswerList: List<Int>
)