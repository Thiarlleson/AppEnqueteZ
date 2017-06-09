package com.example.thiarlleson.enquentez.DAO;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class Firebase{

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;

    //Singleton para a instancia da referencia do FirebaseDatabase
    public static DatabaseReference getReferenciaFirebase(){

        if (referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciaFirebase;
    }


    //Singleton para a instancia da  autenticao do Firebase
    public static FirebaseAuth getAuthFirebase(){

        if (autenticacao==null) {
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

}
