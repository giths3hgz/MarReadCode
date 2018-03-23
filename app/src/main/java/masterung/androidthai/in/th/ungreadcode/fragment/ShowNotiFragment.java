package masterung.androidthai.in.th.ungreadcode.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import masterung.androidthai.in.th.ungreadcode.NotificationActivity;
import masterung.androidthai.in.th.ungreadcode.R;
import masterung.androidthai.in.th.ungreadcode.utility.ChangeStringToArray;
import masterung.androidthai.in.th.ungreadcode.utility.EditStatusWhereidUserAndStatus;
import masterung.androidthai.in.th.ungreadcode.utility.MyConstant;

/**
 * Created by Mavis on 23/03/2018.
 */

public class ShowNotiFragment extends Fragment{
    //ประกาศตัวแปรเพื่อนำไปแสดง
    private String[] messageStrings;
    private String[] loginStrings;
    //


    // ส่งค่าข้อมูลไปใส่ Fragment  ถ่ายเท Data กับ Activity Fragment
    public static ShowNotiFragment showNotiInstance(String[] messageStrings) {
        ShowNotiFragment showNotiFragment = new ShowNotiFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Message", messageStrings);
        showNotiFragment.setArguments(bundle);
        return showNotiFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Argument
        messageStrings = getArguments().getStringArray("Message");
//        Get Value Form SharePreferance
        getValueFromSharePreferance();
        changeStatus();

//        Creat Toolsbar
        creatToolsbar();
//        Create ListView
        createListView();


    }//Main Class

    private void changeStatus() {
        try {
            MyConstant myConstant = new MyConstant();
            EditStatusWhereidUserAndStatus editStatusWhereidUserAndStatus = new EditStatusWhereidUserAndStatus(getActivity());
            editStatusWhereidUserAndStatus.execute(loginStrings[0], myConstant.getUrlEditStatusWhereIDUser());

            Log.d("23MarchV1", "Result From Change Status ==>" + editStatusWhereidUserAndStatus.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getValueFromSharePreferance() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("LoginFile", Context.MODE_PRIVATE);
        String resultString = sharedPreferences.getString("Login", null);
        Log.d("23MarchV1", "result form Perfer ===>" + resultString);
        ChangeStringToArray changeStringToArray = new ChangeStringToArray(getActivity());
        loginStrings = changeStringToArray.myChangeStringToArray(resultString);
    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.listViewMessage);
        ChangeStringToArray changeStringToArray = new ChangeStringToArray(getActivity());
        String[] dateStrings = changeStringToArray.myChangeStringToArray(messageStrings[6]);
        String[] newsStrings = changeStringToArray.myChangeStringToArray(messageStrings[7]);

        // สร้าง วันที่ เวลา และข้อความ ไปแสดงใน ListView
        String[] contentStrings = new String[dateStrings.length];
        for (int i=0; i<dateStrings.length; i+=1) {
            contentStrings[i] = dateStrings[i] + "\n" + newsStrings[i];
        }


        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, contentStrings);
        listView.setAdapter(stringArrayAdapter);


    }


    private void creatToolsbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarShowNoti);
        ((NotificationActivity)getActivity()).setSupportActionBar(toolbar);
        ((NotificationActivity)getActivity()).getSupportActionBar().setTitle(messageStrings[3]);

        ((NotificationActivity) getActivity()).getSupportActionBar().setSubtitle(loginStrings[1] + " Parent");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_notification,
                container, false);
        return view;
    }
} //Main Class
