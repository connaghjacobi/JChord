package main;

public class Standard {
	
	private Notes[] tuningGuitar = {Notes.E, Notes.A, Notes.D, Notes.G, Notes.B, Notes.E}; //
	private Notes[] minorScale = {Notes.A,Notes.B,Notes.C,Notes.D,Notes.E,Notes.F, Notes.G, Notes.A};
	private Notes[] majorScale = {Notes.A,Notes.B,Notes.CS,Notes.D,Notes.E,Notes.FS,Notes.GS,Notes.A};
	private Notes[] minorPentScale = {Notes.A, Notes.C,Notes.D,Notes.E,Notes.G};
	private Notes[] MajorPentScale = {Notes.A, Notes.B, Notes.CS,Notes.E, Notes.FS,Notes.A};
	
	public Standard(){
		
	}
	
	public Notes[] getGuitarTuning(){
		return tuningGuitar;
	}

}
