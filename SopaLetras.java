package sopaletras;

import java.util.Scanner;

public class SopaLetras {
	protected char[][] tabla;
	protected String[] palabras;
	private Scanner sc=new Scanner(System.in);
	
	public SopaLetras(int alto, int ancho, int cantidad) {
		tabla=new char[alto][ancho];
		palabras=new String[cantidad];
	}
	
	public void cargar() {
		for(int i=0; i<tabla.length; i++) {
			for(int j=0; j<tabla[i].length; j++) {
				System.out.println("fila "+i+" columna "+j);
				tabla[i][j]=sc.nextLine().charAt(0);
			}
		}
		System.out.println("introduce las palabras a buscar");
		for(int i=0; i<palabras.length; i++) {
			palabras[i]=sc.nextLine();
		}
	}
	
	public void cargar(char[][] t, String[] p) {
		for(int i=0; i<tabla.length; i++) {
			for(int j=0; j<tabla[i].length; j++) {
				tabla[i][j]=t[i][j];
			}
		}
		for(int i=0; i<palabras.length; i++) {
			palabras[i]=p[i];
		}
	}
	
	public int[] buscar(String p) {
		int[] n=new int[3];
		boolean a=false;
		for(int i=0; i<tabla.length; i++) {
			for(int j=0; j<tabla[i].length; j++) {
				if(tabla[i][j]==p.charAt(0)){
					int au1=i;
					int au2=j;
					for(int x=0; x<p.length(); x++) {
						if(au1>=0 && tabla[au1][au2]==p.charAt(x)) {
							a=true;
							au1--;
						}
						else {
							a=false;
							x=p.length();
						}
					}
					if(a) {
						n[0]=i;
						n[1]=j;
						n[2]=0;
						return n;
					}
					else {
						au1=i;
						au2=j;
						for(int x=0; x<p.length(); x++) {
							if(au1>=0 && au2<tabla[i].length && tabla[au1][au2]==p.charAt(x)) {
								a=true;
								au1--;
								au2++;
							}
							else {
								a=false;
								x=p.length();
							}
						}
						if(a) {
							n[0]=i;
							n[1]=j;
							n[2]=1;
							return n;
						}
						else {
							au1=i;
							au2=j;
							for(int x=0; x<p.length(); x++) {
								if(au2<tabla[i].length && tabla[au1][au2]==p.charAt(x)) {
									a=true;
									au2++;
								}
								else {
									a=false;
									x=p.length();
								}
							}
							if(a) {
								n[0]=i;
								n[1]=j;
								n[2]=2;
								return n;
							}
							else {
								au1=i;
								au2=j;
								for(int x=0; x<p.length() ; x++) {
									if(au1<tabla.length && au2<tabla[i].length &&  tabla[au1][au2]==p.charAt(x)) {
										a=true;
										au1++;
										au2++;
									}
									else {
										a=false;
										x=p.length();
									}
								}
								if(a) {
									n[0]=i;
									n[1]=j;
									n[2]=3;
									return n;
								}
								else {
									au1=i;
									au2=j;
									for(int x=0; x<p.length(); x++) {
										if(au1>tabla.length && tabla[au1][au2]==p.charAt(x)) {
											a=true;
											au1++;
										}
										else {
											a=false;
											x=p.length();
										}
									}
									if(a) {
										n[0]=i;
										n[1]=j;
										n[2]=4;
										return n;
									}
									else {
										au1=i;
										au2=j;
										for(int x=0; x<p.length(); x++) {
											if(au1<tabla.length && au2>=0 && tabla[au1][au2]==p.charAt(x)) {
												a=true;
												au1++;
												au2--;
											}
											else {
												a=false;
												x=p.length();
											}
										}
										if(a) {
											n[0]=i;
											n[1]=j;
											n[2]=5;
											return n;
										}
										else {
											au1=i;
											au2=j;
											for(int x=0; x<p.length(); x++) {
												if(au2>=0 && tabla[au1][au2]==p.charAt(x)) {
													a=true;
													au2--;
												}
												else {
													a=false;
													x=p.length();
												}
											}
											if(a) {
												n[0]=i;
												n[1]=j;
												n[2]=6;
												return n;
											}
											else {
												au1=i;
												au2=j;
												for(int x=0; x<p.length(); x++) {
													if(au1>=0 && au2>=0 && tabla[au1][au2]==p.charAt(x)) {
														a=true;
														au1--;
														au2--;
													}
													else {
														a=false;
														x=p.length();
													}
												}
												if(a) {
													n[0]=i;
													n[1]=j;
													n[2]=7;
													return n;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		n[0]=-1;
		n[1]=-1;
		n[2]=-1;
		return n;
	}
	
	public char[][] resolver(){
		char[][] respuesta=new char[tabla.length][tabla[0].length];
		for(int a=0; a<palabras.length; a++) {
			int n[]=buscar(palabras[a]);
			int i=n[0];
			int j=n[1];
			switch(n[2]) {
			case 0:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i--;
				}
				break;
			case 1:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i--;
					j++;
				}
				break;
			case 2:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					j++;
				}
				break;
			case 3:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i++;
					j++;
				}
				break;
			case 4:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i++;
				}
				break;
			case 5:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i++;
					j--;
				}
				break;
			case 6:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					j--;
				}
				break;
			case 7:
				for(int b=0; b<palabras[a].length(); b++) {
					respuesta[i][j]=palabras[a].charAt(b);
					i--;
					j--;
				}
				break;
			default:
			}
		}	
		return respuesta;
	}

}
