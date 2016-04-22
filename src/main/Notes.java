package main;

public enum Notes {
	A,AS,B,C,CS,D,DS,E,F,FS,G,GS;
	
	public Notes increment(Notes n, int val){
		
		if(val == 0){
			return n;
			
		}else{
			val--;
			Notes r;
			if(n == GS){
				r  = A;
			}else{
				r  = Notes.values()[n.ordinal()+1];
			}
			return increment(r, val);
		}	
		
	}
	@Override
	public String toString(){
		Notes a = Notes.values()[ordinal()] ;
		
		switch(a){
			case A: return "A";
			case AS: return "A#";
			case B: return "B";
			case C: return "C";
			case CS: return "C#";
			case D: return "D";
			case DS: return "D#";
			case E: return "E";
			case F: return "F";
			case FS: return "F#";
			case G: return "G";
			case GS: return "G#";
		
		}
		
		
		return "";
		
	}
	
	
}
