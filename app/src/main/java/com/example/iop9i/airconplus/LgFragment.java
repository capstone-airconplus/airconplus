package com.example.iop9i.airconplus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SamsungFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SamsungFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LgFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //삼성 고객센터 크롤링 부분
    private View v;
    private TextView lg_crawling1;
    private TextView lg_crawling2;
    private TextView lg_crawling3;
    private TextView lg_crawling4;
    private TextView lg_crawling5;
    private TextView lg_crawling6;
    private TextView lg_crawling7;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LgFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to crea te a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SamsungFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LgFragment newInstance(String param1, String param2) {
        LgFragment fragment = new LgFragment ();
        Bundle args = new Bundle ();
        args.putString (ARG_PARAM1, param1);
        args.putString (ARG_PARAM2, param2);
        fragment.setArguments (args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        if (getArguments () != null) {
            mParam1 = getArguments ().getString (ARG_PARAM1);
            mParam2 = getArguments ().getString (ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //크롤링 부분
        v = inflater.inflate (R.layout.fragment_lg, container, false);
        //크롤링 부분 코드 필요없어서 안씀 일달 두었음
        lg_crawling1 = (TextView) v.findViewById (R.id.lgcrawling1);
        lg_crawling2 = (TextView) v.findViewById (R.id.lgcrawling2);
        lg_crawling3 = (TextView) v.findViewById (R.id.lgcrawling3);
        lg_crawling4 = (TextView) v.findViewById (R.id.lgcrawling4);
        lg_crawling5 = (TextView) v.findViewById (R.id.lgcrawling5);
        lg_crawling6 = (TextView) v.findViewById (R.id.lgcrawling6);
        lg_crawling7 = (TextView) v.findViewById (R.id.lgcrawling7);
/*        new Crawling (samsung_crawling1).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling2).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling3).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling4).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling5).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling6).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
*/
        lg_crawling1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28552&itemId=20150865516069"));
                startActivity (myintent);
            }

        });
        lg_crawling2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28551&itemId=20150865512309"));
                startActivity (myintent);
            }

        });
        lg_crawling3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28565&itemId=20150859281424"));
                startActivity (myintent);
            }

        });
        lg_crawling4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28564&itemId=20150859244936"));
                startActivity (myintent);
            }

        });
        lg_crawling5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28462&itemId=20150826317412"));
                startActivity (myintent);
            }

        });
        lg_crawling6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/simple/selectSimpleSearchDetail.do?gubun=SCS&type=keyword&seq=28446&itemId=20150824952348"));
                startActivity (myintent);
            }

        });
        lg_crawling7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.lgservice.co.kr/keywordSearch/simpleEasySearchPage.do"));
                startActivity (myintent);
            }

        });


        //사이트와 검사를 통한 클래스 아이디 가져온다

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction (uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach ();
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