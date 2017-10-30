package com.gael.projects.design.models

/**
 * Created by gael on 30.10.17.
 */

class Test(testBuilder: TestBuilder) {

    private val name: String?

    init {
        name = testBuilder.name
    }

    class TestBuilder {

        var name: String? = null

        fun setName(value: String): TestBuilder {
            this.name = value
            return this
        }

        fun build(): Test {
            return Test(this)
        }
    }
}
