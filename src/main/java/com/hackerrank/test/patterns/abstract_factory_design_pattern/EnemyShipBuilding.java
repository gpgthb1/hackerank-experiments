package com.hackerrank.test.patterns.abstract_factory_design_pattern;

/**
 * Created by txcakaloglu on 2/9/17.
 */
public abstract class EnemyShipBuilding {

    // This acts as an ordering mechanism for creatingEnemyShips that have
    // a weapon,
    // a engine,
    // a name

    // The specific parts used for engine & weapon depend
    // upon the String that is passed to this method

    protected abstract EnemyShip buildingEnemyShip(String typeOfShip);

    // When called a new EnemyShip is made. The specific parts are based on the String entered.
    // After the ship is built, we execute multiple methods in the EnemyShip Object

    public EnemyShip orderTheShip(String typeOfShip) {
        EnemyShip theEnemy = buildingEnemyShip(typeOfShip);
       // theEnemy.makeShip();
        theEnemy.displayEnemyShip();
        //theEnemy.followeHeroShip();
        //theEnemy.enemyShipShoots();
        return theEnemy;
    }


}
