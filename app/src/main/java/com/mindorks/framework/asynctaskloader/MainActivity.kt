package com.mindorks.framework.asynctaskloader

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader


//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<List<Employee>> {

    var empAdapter: EmployeeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        empAdapter = EmployeeAdapter(this, ArrayList())
        val employeeListView: ListView = findViewById<View>(R.id.employees) as ListView
        employeeListView.setAdapter(empAdapter)
        LoaderManager.getInstance(this).initLoader(1, null, this).forceLoad()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<List<Employee>> {
        return EmployeeLoader(this@MainActivity)
    }

    override fun onLoadFinished(loader: Loader<List<Employee>>, data: List<Employee>) {
        empAdapter!!.setEmployees(data)
    }

    override fun onLoaderReset(loader: Loader<List<Employee>>) {
        empAdapter!!.setEmployees(ArrayList())
    }
}