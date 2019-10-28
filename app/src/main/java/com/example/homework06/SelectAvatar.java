package com.example.homework06;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SelectAvatar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SelectAvatar extends Fragment {

    private OnFragmentInteractionListener mListener;

    public SelectAvatar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_select_avatar, container, false);
        view.findViewById(R.id.iv_avatar_f_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(1);
            }
        });
        view.findViewById(R.id.iv_avatar_m_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(2);
            }
        });
        view.findViewById(R.id.iv_avatar_f_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(3);
            }
        });
        view.findViewById(R.id.iv_avatar_m_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(4);
            }
        });
        view.findViewById(R.id.iv_avatar_f_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(5);
            }
        });
        view.findViewById(R.id.iv_avatar_m_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onImageClicked(6);
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
        void onImageClicked(int id);
    }
}
