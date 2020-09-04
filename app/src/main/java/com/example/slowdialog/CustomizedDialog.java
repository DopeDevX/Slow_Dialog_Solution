package com.example.slowdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

public class CustomizedDialog extends AppCompatDialogFragment {
    private EditText widthEditText, heightEditText;
    Spinner orientationSpinner;
    Spinner paperSizeSpinner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.customize_dialog, null);

        builder.setView(dialog)
                .setTitle("Customize")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Let's go!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        widthEditText = dialog.findViewById(R.id.width_et);
        heightEditText = dialog.findViewById(R.id.height_et);

        widthEditText.setEnabled(false);
        heightEditText.setEnabled(false);

        paperSizeSpinner = dialog.findViewById(R.id.paper_size_spinner);
        orientationSpinner = dialog.findViewById(R.id.orientation_spinner);
        ArrayList<String> paperSizes = new ArrayList<>();
        paperSizes.add("A0");
        paperSizes.add("A1");
        paperSizes.add("A2");
        paperSizes.add("A3");
        paperSizes.add("A4");
        paperSizes.add("A5");
        paperSizes.add("Custom");
        ArrayList<String> orientation = new ArrayList<>();
        orientation.add("Portrait");
        orientation.add("Landscape");
        ArrayAdapter<String> paperSizeAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, paperSizes);
        ArrayAdapter<String> orientationAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, orientation);
        paperSizeSpinner.setAdapter(paperSizeAdapter);
        orientationSpinner.setAdapter(orientationAdapter);

        paperSizeSpinner.setSelection(4);
        return builder.create();
    }
}
