/*
  --*java*--
  Brukergrensesnitt krever metodene giStatus og beOmKommando
*/

interface Brukergrensesnitt {
    // giStatus gir bruker beskjed om hva som foregår i spillet
    // @ String status
    void giStatus(String status);
    
    // Gir bruker et valg med parameteren spoersmaal
    // alternativene som svar er gitt av alternativer
    // returnerer valget
    // param @ int spoersmaal
    // param @ String[] alternativer
    // return @ int
    int beOmKommando(String spoersmaal, String[] alternativer);
}
