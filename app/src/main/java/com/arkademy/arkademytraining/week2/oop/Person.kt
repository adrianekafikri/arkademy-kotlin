package com.arkademy.arkademytraining.week2.oop

/**
 * Created by adrianfikri on 2020-01-26.
 * Inheritance concept
 */
open class Person {

    protected var name = ""
    protected var email = ""
    protected var phoneNo = ""
    protected var address = ""

    init {
        email = "person@mail.com"
    }

    protected fun addName(personName: String) {
        name = personName
    }

    class Student: Person() {
        private var studentId = 0
        private var studentgrade = ""

        fun addStudentName(studentName: String) {
            addName(studentName)
        }

        fun setStudentId(id: Int) {
            studentId = id
        }

        fun setGrade(grade: String) {
            studentgrade = grade
        }
    }

    open class Teacher: Person() {
        private var subject = ""

        fun addTeacherName(teacherName: String) {
            addName(teacherName)
        }

        class PrivateTeacher: Teacher() {
            private var student: Student = Student()

            fun setStudentProperty(studentId: Int, grade: String) {
                student.setStudentId(studentId)
                student.setGrade(grade)
            }

            fun setTecherName(teacherName: String) {
                addTeacherName(teacherName)
            }

            fun setStudentName(studentName: String) {
                student.addStudentName(studentName)
            }
        }

        class PublicTeacher: Teacher() {
            private var school = ""

            fun setTecherName(teacherName: String) {
                addName(teacherName)
            }
        }
    }
}