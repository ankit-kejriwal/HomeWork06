package com.example.homework06;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView imageView;
    RadioGroup radioGroup;
    int selectedButton =0;
    String fname, lname, department,studentId;
    int imageVal;
    Button buttonsave;
    EditText editTextfname;
    EditText editTextlname;
    EditText editTextsid;

    private OnFragmentInteractionListener mListener;

    public MyProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfile newInstance(String param1, String param2) {
        MyProfile fragment = new MyProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        if(mListener.getMessage() !=-1){
            imageVal  = mListener.getMessage();
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
        }
        Student student = mListener.getStudent();
        if(student!=null){
            editTextfname.setText(student.getFname());
            editTextlname.setText(student.getLname());
            editTextsid.setText(student.getStudentId());
            Log.d("demo",student.getDepartment());
            if(student.getDepartment().equals("CS"))
            {
                radioGroup.check(R.id.rb_cs);
            }
            else if(student.getDepartment().equals("SIS"))
            {
                radioGroup.check(R.id.rb_sis);
            }
            else if(student.getDepartment().equals("BIO"))
            {
                radioGroup.check(R.id.rb_bio);
            }
            else if(student.getDepartment().equals("Other"))
            {
                radioGroup.check(R.id.rb_other);
            }
        }
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        editTextfname = view.findViewById(R.id.et_firstname);
        editTextlname = view.findViewById(R.id.et_lastname);
        editTextsid = view.findViewById(R.id.et_id);
        imageView = view.findViewById(R.id.iv_my_avatar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClickListener();
            }
        });
        radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedButton= radioGroup.getCheckedRadioButtonId();

                if(selectedButton==R.id.rb_cs)
                {
                    department="CS";
                }
                else if(selectedButton==R.id.rb_sis)
                {
                    department="SIS";
                }
                else if(selectedButton==R.id.rb_bio)
                {
                    department="BIO";
                }
                else if(selectedButton==R.id.rb_other)
                {
                    department="Other";
                }
            }
        });
        buttonsave = view.findViewById(R.id.btn_save);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname = editTextfname.getText().toString();
                lname = editTextlname.getText().toString();
                studentId = editTextsid.getText().toString();
                if(imageVal==0)
                {
                    Toast.makeText(getActivity(), "Select an Avatar", Toast.LENGTH_SHORT).show();
                }
                else if(fname.equals(""))
                {
                    Toast.makeText(getActivity(),"Enter first name", Toast.LENGTH_SHORT).show();
                }
                else if(lname.equals(""))
                {
                    Toast.makeText(getActivity(),"Enter last name", Toast.LENGTH_SHORT).show();
                }
                else if(studentId.length()!=9)
                {
                    Toast.makeText(getActivity(), "Enter a valid Student ID", Toast.LENGTH_SHORT).show();
                }
                else if (selectedButton==0)
                {
                    Toast.makeText(getActivity(), "Select a department", Toast.LENGTH_SHORT).show();
                }
                else {


                    Student student = new Student(fname, lname, department, studentId, imageVal);
                    mListener.setStudent(student);
                    mListener.moveFromProfileToDisplayFragment();
                }
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
        // TODO: Update argument type and name
        void onImageClickListener();
        int getMessage();
        void setStudent(Student student);
        Student getStudent();
        void moveFromProfileToDisplayFragment();
    }
}
