package com.example.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.base.BaseFragment;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Fragment, añadir/editar una dependencia
 */

public class AddEditDependency_Fragment extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditDependency";

    AddEditDependencyContract.Presenter presenter;

    FloatingActionButton fab_addDependency;
    TextInputEditText tID_DependencyName;
    TextInputEditText tID_DependencyShortname;
    TextInputEditText tID_DependencyDescription;

    public static AddEditDependency_Fragment newInstance(Bundle args) {

        AddEditDependency_Fragment addeditDependency = new AddEditDependency_Fragment();

        if (args != null)
        {
            addeditDependency.setArguments(args);
        }

        return addeditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dependencyaddedit_fragment, container, false);

        tID_DependencyDescription = (TextInputEditText) rootView.findViewById(R.id.edtDescription);
        tID_DependencyDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tID_DependencyDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tID_DependencyShortname = (TextInputEditText) rootView.findViewById(R.id.edtShortname);
        tID_DependencyName = (TextInputEditText) rootView.findViewById(R.id.edtName);

        fab_addDependency = (FloatingActionButton) rootView.findViewById(R.id.fab_dependency);
        fab_addDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateDependency(tID_DependencyName.getText().toString(),
                                                tID_DependencyShortname.getText().toString(),
                                                    tID_DependencyDescription.getText().toString());
            }
        });

        if (getArguments() != null)
        {

        }

        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void setNameError() {
        tID_DependencyName.setError("Nombre de dependencia vacío");
    }

    @Override
    public void setDescError() {
        tID_DependencyDescription.setError("Descripcion vacía");
    }

    @Override
    public void setShortnameError() {
        tID_DependencyShortname.setError("Nombre corto vacío");

    }

    // Si to-do es correcto, volvemos para mostrar la lista de dependencias
    // con la nueva dependencia añadida
    @Override
    public void addingCorrectDependency() {

    }
}
