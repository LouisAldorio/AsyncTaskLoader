package com.mindorks.framework.asynctaskloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class EmployeeAdapter(
    context: Context?,
    employees: MutableList<Employee>
) :
    BaseAdapter() {
    private val inflater: LayoutInflater
    private var employees: MutableList<Employee> = ArrayList()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
        var view: View? = view
        val (empid1, name) = getItem(position) as Employee
        if (view == null) {
            view = inflater.inflate(R.layout.employeedata, null)
        }
        val empid = view?.findViewById(R.id.empid) as TextView
        empid.text = empid1
        val empname = view.findViewById(R.id.empname) as TextView
        empname.text = name
        return view
    }

    override fun getItem(position: Int): Any {
        return employees[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return employees.size
    }

    fun setEmployees(data: List<Employee>) {
        employees.addAll(data)
        notifyDataSetChanged()
    }

    init {
        this.employees = employees
        inflater = LayoutInflater.from(context)
    }
}