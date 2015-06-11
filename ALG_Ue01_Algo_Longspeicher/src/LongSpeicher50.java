<<<<<<< HEAD
/*
 * ###########################################################################
 * Projekt 5: Sammeln in einem binÃ¤ren Baum
 * 1.  Grundbegriffe
 * 2.  ParameterÃ¼bergabe in Java
 * 3.  Ziel
 * 4.  Vorgaben
 */

=======
>>>>>>> 2ea34df23874a6980e7c621198e67c00bd9dad25
class LongSpeicher50 implements LongSpeicher {
   // ---------------------------------------------------------------------
   // Zum Ein-/Ausschalten von Testbefehlen:
   static final boolean TST1 = true;
   // ---------------------------------------------------------------------
   // Zwei (statische) geschachtelte Klassen (nested static class)

   static protected class Knoten {
      RefK lubr; // Referenz auf linken  Unterbaum
      RefK rubr; // Referenz auf rechten Unterbaum
      long data;

      Knoten(RefK lubr, RefK rubr, long data) {  // Konstruktor
         this.lubr = lubr;
         this.rubr = rubr;
         this.data = data;
      }
   }

   static protected class RefK {
      Knoten k;
<<<<<<< HEAD
      RefK(Knoten k) {this.k = k;}               // Konstruktor
=======
      RefK(Knoten k){ 
      this.k = k;
      }               // Konstruktor
>>>>>>> 2ea34df23874a6980e7c621198e67c00bd9dad25
   }
   // ---------------------------------------------------------------------
   // Ein leerer Baum besteht aus einem End-Dummy-Knoten EDK.
   // Das RefK-Attribut AR (Anfangs-Referenz) zeigt anfangs auf den EDK
   // und spaeter auf den ersten "richtigen Knoten" (die Wurzel) des Baums:
   private final Knoten EDK = new Knoten(null, null, 0);
   private final RefK   AR  = new RefK(EDK);
   // ---------------------------------------------------------------------
   private RefK refk(long n) {
      // Liefert ein RefK-Objekt hier fuer welches gilt:
      // hier.k.data == n.
      // Falls n in diesem Speicher nicht vorkommt, ist
      // der Knoten hier.k gleich dem EDK.

      EDK.data = n;
      return refkR(n, AR);
   }

   private RefK refkR(long n, RefK hier) {
      // Eine rekursive Methode, die erledigt, was die Methode refk
      // versprochen hat.

      if (n < hier.k.data) {
<<<<<<< HEAD
    	  								// links weitersuchen
      } else if (n > hier.k.data) {
    	  								// rechts weitersuchen
      } else {                         	// jetzt gilt n == hier.k.data
      
      }
	return null;
   }
   // ---------------------------------------------------------------------

=======
         ...                           // links weitersuchen
      } else if (n > hier.k.data) {
         ...                           // rechts weitersuchen
      } else {                         // jetzt gilt n == hier.k.data
         ...
      }
   }
>>>>>>> 2ea34df23874a6980e7c621198e67c00bd9dad25

@Override
public boolean fuegeEin(long n) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean loesche(long n) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean istDrin(long n) {
	// TODO Auto-generated method stub
	return false;
<<<<<<< HEAD
} 
=======
}
   // ---------------------------------------------------------------------
   ...
>>>>>>> 2ea34df23874a6980e7c621198e67c00bd9dad25
}
