package com.peppermint.exception;

/**
 * @author Administrator
 */
public class Hero {
    public String name;
    protected float hp;


    public void attackHero(Hero hero) throws EnemyHeroIsDeadException{
        if (hero.hp==0){
            throw new EnemyHeroIsDeadException(hero.name+"已经死了，不能放技能");
        }
    }

    @Override
    public String toString(){
        return name;
    }

    class EnemyHeroIsDeadException extends Exception{
        public EnemyHeroIsDeadException(){
        }
        public EnemyHeroIsDeadException(String msg){
            super(msg);
        }
    }

    public static void main(String[] args) {
        Hero garen=new Hero();
        garen.name="盖伦";
        garen.hp=666;

        Hero teemo=new Hero();
        teemo.hp=0;
        teemo.name="提莫";

        try {
            garen.attackHero(teemo);
        } catch (EnemyHeroIsDeadException e) {
            System.out.println("具体的异常信息："+e.getMessage());
            e.printStackTrace();
        }
    }
}
