package com.example.abiduzair.tabbed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link current.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link current#newInstance} factory method to
 * create an instance of this fragment.
 */
public class current extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public current() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment current.
     */
    // TODO: Rename and change types and number of parameters
    public static current newInstance(String param1, String param2) {
        current fragment = new current();
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
String t1,t2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myinflatedView=inflater.inflate(R.layout.fragment_current, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            t1= bundle.getString("e1");
            t2= bundle.getString("e2");
            RelativeLayout rl = (RelativeLayout) myinflatedView.findViewById(R.id.rl);
            ScrollView sv = (ScrollView) myinflatedView.findViewById(R.id.sv);
            LinearLayout ll1 = (LinearLayout) myinflatedView.findViewById(R.id.ll1);
            CardView cv=(CardView)myinflatedView.findViewById(R.id.cv);
            LinearLayout ll2 = (LinearLayout) myinflatedView.findViewById(R.id.ll2);
            LinearLayout ll3 = (LinearLayout) myinflatedView.findViewById(R.id.ll3);
            TextView tv1 = (TextView) myinflatedView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) myinflatedView.findViewById(R.id.tv2);
            tv1.setText(t1);
            tv2.setText(t2);
            if (tv1.getParent() != null)
                ((ViewGroup) tv1.getParent()).removeView(tv1);
            ll3.addView(tv1);
            if (tv2.getParent() != null)
                ((ViewGroup) tv2.getParent()).removeView(tv2);
            ll3.addView(tv2);
            if (ll3.getParent() != null)
                ((ViewGroup) ll3.getParent()).removeView(ll3);
            ll2.addView(ll3);
            if (ll2.getParent() != null)
                ((ViewGroup) ll2.getParent()).removeView(ll2);
            cv.addView(ll2);
            if (cv.getParent() != null)
                ((ViewGroup) cv.getParent()).removeView(cv);
            ll1.addView(cv);
            if (ll1.getParent() != null)
                ((ViewGroup) ll1.getParent()).removeView(ll1);
            sv.addView(ll1);
            if (sv.getParent() != null)
                ((ViewGroup) sv.getParent()).removeView(sv);
            rl.addView(sv);
        }
        return myinflatedView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        void onFragmentInteraction(Uri uri);
    }
}
