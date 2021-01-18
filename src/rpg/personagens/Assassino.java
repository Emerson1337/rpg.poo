package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Assassino extends Personagem{
	private Ataques attSp = new Ataques("EXECU��O PERFEITA", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("AUTO-ATAQUE", TipoDoAtaque.valueOf("AD"));
	public List <Integer> attEspecial = new ArrayList<>();
	public Assassino(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 160;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 45;
		armadura = 30;
		resistenciaMagica = 30;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
                pontosHabilidade = 0;
		tipo = TiposDePersonagem.valueOf("ASSASSINO");
	}
	
        @Override
	public void ataqueEspecial(Personagem atacado, int verif) {
            
            if(pontosHabilidade == 1){
                pontosHabilidade = 0;
                
                int aux = (int) (0.15 * poderAtaqueFisico);
                
                int poderAtaqueFisicoEspecial = aux + poderAtaqueFisico;
                int poderDeHabilidadeEspecial = 0;
                

                attEspecial.clear();
                attEspecial.add(poderAtaqueFisicoEspecial);
                attEspecial.add(poderDeHabilidadeEspecial);
                
                
                
                atacado.setPontosDeVida(atacado.getPontosDeVida() - verif);
            } else {
                 System.out.println("Sua habilidade especial ainda n�o est� pronta.\n");
            }
	}
        
        @Override
        public void ataquePadrao(Personagem atacado, int verif){
            atacado.setPontosDeVida(atacado.getPontosDeVida() - verif);
        }
        
        @Override
        public void aprimorarDefesa(Personagem defensor, int defesa){
        defensor.setResistenciaMagica(defesa + 5);
        }
        
        @Override
        public void aprimorarArmadura(Personagem defensor, int defesa){
        defensor.setArmadura(defesa + 5);
        }
        
        @Override
        public List<Integer> getAtaqueDoAtaqueEspecial(){
            return attEspecial;
        }
	
	@Override
	public void powerUp() {
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
		poderDeHabilidade += 0.08 * poderDeHabilidade;
                pontosHabilidade += 1;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Assassino" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque F�sico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResist�ncia M�gica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
