package com.francis.mvvm.utils

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast

object UiUtils {

    fun showLoadingDialog(context: Context?, message: String?): ProgressDialog {
        var progressDialog = ProgressDialog(context)
        progressDialog.setMessage(message)
        return progressDialog
    }

    fun showToast(context: Context, msg: String?) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show()
    }

}
