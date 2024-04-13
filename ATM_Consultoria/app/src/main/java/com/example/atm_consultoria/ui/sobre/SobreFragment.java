package com.example.atm_consultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atm_consultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Para pegar a versão do app
        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        String descricao = "ATM Consultoria tem como missão apoiar organização " +
                "que desejam alcançar o sucesso da excelência em gestão e da busca pela qualidade.";

        View view = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://google.com/", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("atmconsultoria", "Facebook")
                .addInstagram("atmconsultoria", "Instagram")
                .addTwitter("atmconsultoria", "Twitter")
                .addYoutube("atmconsultoria", "YouTube")
                .addGitHub("atmconsultoria", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")
                .addItem(versao)
                .create();

        return view;
    }
}