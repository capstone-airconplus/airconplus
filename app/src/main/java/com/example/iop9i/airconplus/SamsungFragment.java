package com.example.iop9i.airconplus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SamsungFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SamsungFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SamsungFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //삼성 고객센터 크롤링 부분
    private View v;
    private TextView samsung_crawling1;
    private TextView samsung_crawling2;
    private TextView samsung_crawling3;
    private TextView samsung_crawling4;
    private TextView samsung_crawling5;
    private TextView samsung_crawling6;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SamsungFragment() {
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
    public static SamsungFragment newInstance(String param1, String param2) {
        SamsungFragment fragment = new SamsungFragment ();
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
        v = inflater.inflate (R.layout.fragment_samsung, container, false);
        //크롤링 부분 코드 필요없어서 안씀 일달 두었음
        samsung_crawling1 = (TextView) v.findViewById (R.id.samsungcrawling1);
        samsung_crawling2 = (TextView) v.findViewById (R.id.samsungcrawling2);
        samsung_crawling3 = (TextView) v.findViewById (R.id.samsungcrawling3);
        samsung_crawling4 = (TextView) v.findViewById (R.id.samsungcrawling4);
        samsung_crawling5 = (TextView) v.findViewById (R.id.samsungcrawling5);
        samsung_crawling6 = (TextView) v.findViewById (R.id.samsungcrawling6);
/*        new Crawling (samsung_crawling1).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling2).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling3).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling4).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling5).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
        new Crawling (samsung_crawling6).execute ("https://www.samsungsvc.co.kr/online/faqList.do?pageNo=1&page=1&searchOrder=PAGE_CREATED_DATE_DESC&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&faq=NODE0000124944&video=&download=&diagnosis=&coreword2=%BD%BA%C5%C4%B5%E5+%BF%A1%BE%EE%C4%C1&coreword1=%BF%A1%BE%EE%C4%C1&code=S021&searchTarget=&selectCtgrCodeFAQ=NODE0000145783&presearchTarget=&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC&anchorG=Y&q=&w=srch_faq&sq=&vsq=&dsort=&fsort=&oneCode=&pg=&onSrch=&faqListOrderBy=&d1=&d2=#anc","strong[class=lst_tit]");
*/
        samsung_crawling1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000041003&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
                startActivity (myintent);
            }

        });
        samsung_crawling2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000040978&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
                startActivity (myintent);
            }

        });
        samsung_crawling3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000040910&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
                startActivity (myintent);
            }

        });
        samsung_crawling4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000040880&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
                startActivity (myintent);
            }

        });
        samsung_crawling5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000040796&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
                startActivity (myintent);
            }

        });
        samsung_crawling6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.samsungsvc.co.kr/online/faqView.do?domainId=NODE0000033866&node_Id=NODE0000145783&faqId=KNOW0000039305&pageNo=1&Lcode=%BB%FD%C8%B0%B0%A1%C0%FC&code=S021&selectCtgrCodeFAQ=NODE0000145783&selectCtgrCodeDIAGNOSIS=NODE0000125081&selectCtgrCodeVIDEO=NODE0000125157&selectCtgrCodeDOWNLOAD=CAC"));
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

//크롤링을 위한 클래스를 만든다
class Crawling extends AsyncTask<String, Void, String>{

    TextView textView;

    public Crawling(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {

        String URL = strings[0];
        String EI = strings[1];
        String result = "";

        try {
            Document document = Jsoup.connect (URL).get ();
            Elements elements = document.select (EI);

            for(Element element : elements){

                result = result+element.text()+"\n";
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return null;
    }


    protected void onPostExecute(String s){
        super.onPostExecute (s);

        textView.setText (s);


    }
}