package com.peppermint.generic;

import com.peppermint.collections.Hero;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        List<? extends Hero> heroList=new ArrayList<>();

    }
}
