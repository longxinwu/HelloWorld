package com.wb.helloworld;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.wb.helloworld.gridView.GridViewActivity;
import com.wb.helloworld.listView.ListViewActivity;
import com.wb.helloworld.myEditText.UpEditTextActivity;
import com.wb.helloworld.recycleView.RecyclerViewActivity;

public class Onclick implements View.OnClickListener {

    private AppCompatActivity activity;

    public Onclick(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_textView_1:
                intent = new Intent(activity, TextViewActivity.class);
                break;
            case R.id.btn_1:
                intent = new Intent(activity, ButtonActivity.class);
                break;
            case R.id.btn_editText_1:
                intent = new Intent(activity, EditTextActivity.class);
                break;
            case R.id.btn_myEditText:
                intent = new Intent(activity, MyEditTextActivity.class);
                break;
            case R.id.btn_myselfEditText:
                intent = new Intent(activity, MySelfEditTextActivity.class);
                break;
            case R.id.btn_upEditText:
                intent = new Intent(activity, UpEditTextActivity.class);
                break;
            case R.id.btn_radio_1:
                intent = new Intent(activity, RadioBtnActivity.class);
                break;
            case R.id.btn_checkBox_1:
                intent = new Intent(activity,CheckBoxActivity.class);
                break;
            case R.id.btn_imageView_1:
                intent = new Intent(activity, ImageViewActivity.class);
                break;
            case R.id.btn_listView_1:
                intent = new Intent(activity, ListViewActivity.class);
                break;
            case R.id.btn_gridView_1:
                intent = new Intent(activity, GridViewActivity.class);
                break;
            case R.id.btn_RV_1:
                intent = new Intent(activity, RecyclerViewActivity.class);
                break;
            case R.id.btn_WV_1:
                intent = new Intent(activity, WebViewActivity.class);
                break;
            case R.id.btn_toast:
                intent = new Intent(activity, ToastActivity.class);
                break;
            case R.id.btn_dialog:
                intent = new Intent(activity, DialogActivity.class);
                break;

            case R.id.btn_progress:
                intent = new Intent(activity, ProgressActivity.class);
                break;
            case R.id.btn_dialog2:
                intent = new Intent(activity, CustomDialogActivity.class);
                break;
            case R.id.btn_pop:
                intent = new Intent(activity, PopUpActivity.class);
                break;
            default:
                break;
        }
        activity.startActivity(intent);
    }
}
