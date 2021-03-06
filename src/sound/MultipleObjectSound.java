package sound;

import java.io.FileNotFoundException;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class MultipleObjectSound extends ObjectiveSound {
	
	private ArrayList<String> arquivo;
	private int contador;
	
	
	public MultipleObjectSound(Float obj_x, Float obj_y, Float obj_z, FloatBuffer listenerPosA, FloatBuffer listenerVelA, FloatBuffer listenerOriA, ArrayList<String> arquivo, int intervalo, Float volume/*Ponto bonecao*/){
		super(obj_x, obj_y, obj_z, listenerPosA, listenerVelA, listenerOriA, /*arquivo,*/ intervalo, volume);
		contador = 0;
		this.arquivo = arquivo;
//		this.obj_x = obj_x;
//		this.obj_y = obj_y;
//		this.obj_z = obj_z;
//		//this.boneco = bonecao;
//		this.listenerPos = listenerPosA;
//		this.listenerVel = listenerVelA;
//		this.listenerOri = listenerOriA;
//		
//		this.jogando = true;
//		
//		this.arquivo = arquivo;
//		this.intervalo = intervalo;
//		this.volume = volume;
	}
	
	
//	public void setObjectPosition(Float obj_x, Float obj_y, Float obj_z){
//		this.obj_x = obj_x;
//		this.obj_y = obj_y;
//		this.obj_z = obj_z;
//	}
//	
//	public void setJogando(boolean jogando){
//		this.jogando = jogando;
//	}
//	
//	public float getObj_x() {
//		return obj_x;
//	}
//
//
//	public void setObj_x(float obj_x) {
//		this.obj_x = obj_x;
//		System.out.println("Novo obj_x = " + this.obj_x + " ( " + obj_x + " ) ");
//	}
//
//
//	public float getObj_y() {
//		return obj_y;
//	}
//
//
//	public void setObj_y(float obj_y) {
//		this.obj_y = obj_y;
//		System.out.println("Novo obj_y = " + this.obj_y + " ( " + obj_y + " ) ");
//	}
//
//
//	public float getObj_z() {
//		return obj_z;
//	}
//
//
//	public void setObj_z(float obj_z) {
//		this.obj_z = obj_z;
//	}
//
//
//	public SoundSource getSource() {
//		return source;
//	}
//
//
//	public void setSource(SoundSource source) {
//		this.source = source;
//	}
//
//
//	public FloatBuffer getListenerPos() {
//		return listenerPos;
//	}
//
//
//	public void setListenerPos(FloatBuffer listenerPos) {
//		this.listenerPos = listenerPos;
//	}
//
//
//	public FloatBuffer getListenerVel() {
//		return listenerVel;
//	}
//
//
//	public void setListenerVel(FloatBuffer listenerVel) {
//		this.listenerVel = listenerVel;
//	}
//
//
//	public FloatBuffer getListenerOri() {
//		return listenerOri;
//	}
//
//
//	public void setListenerOri(FloatBuffer listenerOri) {
//		this.listenerOri = listenerOri;
//	}
//
//
//	public boolean isJogando() {
//		return jogando;
//	}
//
//	public void setArquivo(String arquivo){
//		this.arquivo = arquivo;
//	}

	public void run(){
		SoundSource objective = new SoundSource();
		//this.source = objective;
		setSource(objective);
		/*try {
			objective.execute("latido.wav", obj_y, obj_x, obj_z, listenerPos, listenerVel, listenerOri);
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}*/
		while(isJogando()){
			try {
				objective.execute(/*"latido.wav"*/arquivo.get(this.contador), getObj_y(), getObj_x(), getObj_z(), getListenerPos(), getListenerVel(), getListenerOri(), getVolume());
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			//SoundSource objective = new SoundSource();
			try {
				//System.out.println("( " + boneco.getX() + " , " + boneco.getY() + " ) - ( " + (boneco.getX()+0.0f) + " , " + (boneco.getY()+0.0f) + " )");
				//objective.execute("objective.wav", obj_y, obj_x, obj_z, (boneco.getY()+0.0f), (boneco.getX()+0.0f), (boneco.getZ()+0.0f));
				
				//objective.setSourceValues(obj_y, obj_x, obj_z);
				objective.playSound();
				//if(arquivo.equals("latido.wav") || arquivo.equals("come on lets go.wav")) System.out.println("x:" +obj_y+  " y :"+ obj_x + " z: "+ obj_z);
				Thread.sleep(getIntervalo()/*5000*/);
				this.contador++;
				this.contador = this.contador % this.arquivo.size();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		objective.killALData();
		//talvez precise mudar de lugar
		//AL.destroy();
	}
}
