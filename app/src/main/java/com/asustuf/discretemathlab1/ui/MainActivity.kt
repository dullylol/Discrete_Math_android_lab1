package com.asustuf.discretemathlab1.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.asustuf.discretemathlab1.R
import com.asustuf.discretemathlab1.databinding.ActivityMainBinding
import com.asustuf.discretemathlab1.model.SetsOperations

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val operations = arrayOf("A ⊆ B", "B ⊆ A", "A ∪ B", "A ∩ B", "A / B", "B / A", "A △ B")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var chosenOperation = -1
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Choose sets operation")
                .setSingleChoiceItems(operations, 0) { _: DialogInterface, i: Int ->
                    chosenOperation = i
                }
                .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                    val set1 = mainBinding.set1.text.toSet()
                    val set2 = mainBinding.set2.text.toSet()
                    setResultViewByOperation(chosenOperation, set1, set2)
                    dialogInterface.dismiss()
                }
                .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }

        mainBinding.solveBtn.setOnClickListener {
            alertDialogBuilder.create().show()
        }
    }

    private fun setResultViewByOperation(chosenOperation: Int, set1: Set<Char>, set2: Set<Char>) {
        mainBinding.set1Tv.text = getString(R.string.output_set1, set1.toString())
        mainBinding.set2Tv.text = getString(R.string.output_set2, set2.toString())
        mainBinding.resultTv.text = getString(R.string.output_result, operations[chosenOperation],
                when (chosenOperation) {
                    0 -> SetsOperations.isSubset(set1, set2).toString()
                    1 -> SetsOperations.isSubset(set2, set1).toString()
                    2 -> SetsOperations.union(set1, set2).toString()
                    3 -> SetsOperations.intersection(set1, set2).toString()
                    4 -> SetsOperations.difference(set1, set2).toString()
                    5 -> SetsOperations.difference(set2, set1).toString()
                    6 -> SetsOperations.symmetricDifference(set1, set2).toString()
                    else -> {
                        Toast.makeText(this, "Incorrect operation!", Toast.LENGTH_SHORT).show()
                        ""
                    }
                })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("set_A", mainBinding.set1Tv.text.toString())
        outState.putString("set_B", mainBinding.set2Tv.text.toString())
        outState.putString("result_set", mainBinding.resultTv.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mainBinding.set1Tv.text = savedInstanceState.getString("set_A")
        mainBinding.set2Tv.text = savedInstanceState.getString("set_B")
        mainBinding.resultTv.text = savedInstanceState.getString("result_set")
    }
}