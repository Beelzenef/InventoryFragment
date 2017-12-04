package com.example.inventoryfragment.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {

    public static final String MESSAGE = "mensaje";
    public static final String TITLE = "title";



    public static Dialog showConfirmationDialog(final Bundle b, Context context, final ListDependencyContract.Presenter p)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage(b.getString(CommonDialog.MESSAGE))
                .setTitle(b.getString(CommonDialog.TITLE))
                .setPositiveButton(R.string.btn_Confirmar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        p.removeItem((Dependency)b.getParcelable(Dependency.TAG));
                    }
                })
                .setNegativeButton(R.string.btn_NoConfirmar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Dismiss esconde el dialogo, no nos interesa
                        // Cancel elimina la acción
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

}
