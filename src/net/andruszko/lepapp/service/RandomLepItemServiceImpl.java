/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp.service;

import net.andruszko.lepapp.db.LepProviderMetaData.DictCorrectAns;
import net.andruszko.lepapp.vo.LepItemVO;

/**
 *
 * @author wtk300
 */
public class RandomLepItemServiceImpl implements RandomLepItemService {

    public LepItemVO getRandomItem() {
        LepItemVO item = new LepItemVO();
        item.setPosition(8);
        item.setCorrectAns(DictCorrectAns.ANS_D);
        item.setQuestion("U 55-letniego pacjenta po urazie kręgosłupa z uszkodzeniem rdzenia kręgowego  z utrzymywanym na stałe cewnikiem w pęcherzu moczowym stwierdzamy bakterio-mocz bezobjawowy. U tego pacjenta należy:");
        item.setAnswerA("podać antybiotyk przez okres 7 dni.");
        item.setAnswerB("zmieniać cewnik moczowy po każdym stwierdzeniu bakteriomoczu bezobjawowego.");
        item.setAnswerC("zastosować leczenie antybiotykiem przez okres co najmniej 6 miesięcy.");
        item.setAnswerD("leczenie antybakteryjne zastosować tylko wtedy, gdy występują objawy podmiotowe i przedmiotowe świadczące o ZUM.");
        item.setAnswerE("nigdy nie ma potrzeby leczenia takich pacjentów.");
        return item;
    }
}
