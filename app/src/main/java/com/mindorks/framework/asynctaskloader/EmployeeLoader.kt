package com.mindorks.framework.asynctaskloader

import android.content.Context
import androidx.loader.content.AsyncTaskLoader

class EmployeeLoader(context: Context) : AsyncTaskLoader<List<Employee>>(context) {

    override fun loadInBackground(): List<Employee> {

        val list: MutableList<Employee> = ArrayList()
        list.add(Employee("emp1", "Brahma"))
        list.add(Employee("emp2", "Vishnu"))
        list.add(Employee("emp3", "Mahesh"))

        return list
    }
}