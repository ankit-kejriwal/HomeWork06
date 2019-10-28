package com.example.homework06;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DisplayMyProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DisplayMyProfile extends Fragment {

    TextView textViewName;
    TextView textViewsid;
    TextView textViewdept;
    ImageView imageView;
    Student student;
    Button btnEdit;
    private OnFragmentInteractionListener mListener;

    public DisplayMyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_my_profile, container, false);
        getActivity().setTitle("My Profile");
        imageView = view.findViewById(R.id.iv_my_avatar);
        textViewName = view.findViewById(R.id.tv_fullname);
        textViewsid = view.findViewById(R.id.tv_id);
        textViewdept = view.findViewById(R.id.tv_dept);
        student = mListener.getStudent();
        btnEdit = view.findViewById(R.id.btn_edit);

        textViewName.setText(student.getFname()+" "+student.getLname());
        textViewsid.setText(student.getStudentId());
        textViewdept.setText(student.getDepartment());
        int imageVal  = student.getImageVal();
        if (imageVal == 1) {
            imageView.setImageResource(R.drawable.avatar_f_1);
        } else if (imageVal == 2) {
            imageView.setImageResource(R.drawable.avatar_m_1);
        } else if (imageVal == 3) {
            imageView.setImageResource(R.drawable.avatar_f_2);
        } else if (imageVal == 4) {
            imageView.setImageResource(R.drawable.avatar_m_2);
        } else if (imageVal == 5) {
            imageView.setImageResource(R.drawable.avatar_f_3);
        } else if (imageVal == 6) {
            imageView.setImageResource(R.drawable.avatar_m_3);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.goToMyProfileFragment();
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        Student getStudent();
        void goToMyProfileFragment();
    }
}
