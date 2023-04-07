package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {

    private static final Pelicula p1 = new Pelicula("D. Software",250000);

    private static final Pelicula p2 = new Pelicula("Farinha",500000);

    private static final Pelicula p3 = new Pelicula("Breaking Bad",850000);

    private static final Pelicula p4 = new Pelicula("Probar Errores",100000);

    private static final Pelicula p5 = new Pelicula("Vivir sin Permiso",350000);


    @BeforeAll
    static void addPersonas() {
        p1.addGuionista(new Guionista("David","Alonso Rivers","56178345V","espanhola","616290633",7,true));
        p1.addMusico(new Musico("Joan","Monrow","32143245J","inglesa","988543221",9));
        p1.addProductor(new Productor("Laura","M.F","12345567K","espanhola","600112233",11));
        p1.addDirector(new Director("Eduard","King M","98765432M","inglesa","666666666",11,7));
        p1.addInterprete(new Interprete("Bea","Rodriguez","67587981L","espanhola","722113344",8,true,false,false));
        p1.addEspecialista(new Especialista("Paula","Field","65544333C","estadounidense","676543211",5,true));
        p1.addDoblador(new Doblador("James","Gosling","12343213J","canadiense","616907867",15));

        p2.addGuionista(new Guionista("Ramon","Campos","56232213H","espanhola","9887654323",17,false));
        p2.addMusico(new Musico("Muinheira","de Chantada","12312126Z","espanhola","654321461",3));
        p2.addProductor(new Productor("Nacho","Carretero","4353567G","espanhola","656786534",12));
        p2.addDirector(new Director("Carlos","Sedes","56765432A","espanhola","678543421",10,3));
        p2.addInterprete(new Interprete("Javier", "Rey","67843235S","espanhola","678949302",15,true,false,false));
        p2.addInterprete(new Interprete("Antonio","Duran","678543221","espanhola","65432153",13,true,false,false));
        p2.addEspecialista(new Especialista("Tristan","Ulloa","67576543S","espanhola","675452312",15,true));
        p2.addDoblador(new Doblador("Sheyla","Lils","45762359Y","inglesa","722334455",10));

        p3.addGuionista(new Guionista("Vince","Guilligan","45672350B","estadounidense","766897878",20,true));
        p3.addMusico(new Musico("Ana","Tijoux","43232321D","francesa","765432111",6));
        p3.addProductor(new Productor("Peter","Gould","456788907M","estadounidense","789987654",17));
        p3.addDirector(new Director("Michael","Slovis","45323123K","estadounidense","765432111",13,4));
        p3.addInterprete(new Interprete("Bryan","Cranston","56787980M","estadounidense","787654899",20,true,false,false));
        p3.addInterprete(new Interprete("Aaron","Paul","45787654Q","estadounidense","789654321",18,true,false,false));
        p3.addInterprete(new Interprete("Lavell","Crawford","67565432Z","estadounidense","789000000",6,false,true,false));
        p3.addEspecialista(new Especialista("Giancarlo","Esposito","67898000P","danesa","789765433",10,true));
        p3.addDoblador(new Doblador("Ariel","Abadi","56788976B","espanhola","654321677",15));
    }

    @Test
    void testPrintSalaries() {
        assertEquals("""
                David Alonso Rivers (Screenwriter, original screenplay): 16990.0 euro
                Joan Monrow (Musician): 10540.0 euro
                Laura M.F (Producer): 5990.0 euro
                Eduard King M (Director, 7 years of experience): 20600.0 euro
                Bea Rodriguez (Actor protagonist): 4800.0 euro
                Paula Field (Stunt performer with extra for danger): 1200.0 euro
                James Gosling (Dubber): 300.0 euro
                The total payroll for D. Software is 60420.0 euro""",p1.printSalaries());

        assertEquals("""
           Ramon Campos (Screenwriter, not original screenplay): 26190.0 euro
           Muinheira de Chantada (Musician): 20180.0 euro
           Nacho Carretero (Producer): 11080.0 euro
           Carlos Sedes (Director, 3 years of experience): 29000.0 euro
           Javier Rey (Actor protagonist): 9000.0 euro
           Antonio Duran (Actor protagonist): 7800.0 euro
           Tristan Ulloa (Stunt performer with extra for danger): 1600.0 euro
           Sheyla Lils (Dubber): 200.0 euro
           The total payroll for Farinha is 105050.0 euro""",p2.printSalaries());

        assertEquals("""
                Vince Guilligan (Screenwriter, original screenplay): 47900.0 euro
                Ana Tijoux (Musician): 34360.0 euro
                Peter Gould (Producer): 18530.0 euro
                Michael Slovis (Director, 4 years of experience): 47800.0 euro
                Bryan Cranston (Actor protagonist): 12000.0 euro
                Aaron Paul (Actor protagonist): 10800.0 euro
                Lavell Crawford (Actor secondary): 1200.0 euro
                Giancarlo Esposito (Stunt performer with extra for danger): 1400.0 euro
                Ariel Abadi (Dubber): 300.0 euro
                The total payroll for Breaking Bad is 174290.0 euro""",p3.printSalaries());

    }

    @Test
    void testPrintRoyalties() {
        assertEquals("""
                David Alonso Rivers (Screenwriter): 12500.0 euro
                Joan Monrow (Musician): 10000.0 euro
                Laura M.F (Producer): 5000.0 euro
                Eduard King M (Director): 12500.0 euro
                """,p1.printRoyalties());

        assertEquals("""
           Ramon Campos (Screenwriter): 25000.0 euro
           Muinheira de Chantada (Musician): 20000.0 euro
           Nacho Carretero (Producer): 10000.0 euro
           Carlos Sedes (Director): 25000.0 euro
                """,p2.printRoyalties());

        assertEquals("""
                Vince Guilligan (Screenwriter): 42500.0 euro
                Ana Tijoux (Musician): 34000.0 euro
                Peter Gould (Producer): 17000.0 euro
                Michael Slovis (Director): 42500.0 euro
                """,p3.printRoyalties());
    }

    @Test
    void testListasVacias() {
        assertEquals("The total payroll for Vivir sin Permiso is 0.0 euro",p5.printSalaries());
        assertEquals("",p5.printRoyalties());
    }

    @Test
    void testErrorExceptions() {
        assertThrows(IllegalArgumentException.class, () -> p4.addDirector(new Director("Joe","Gomez","56787234B","inglesa","722876522",3,-2)));
        assertThrows(IllegalArgumentException.class, () -> p4.addProductor(new Productor("Jon","Guidetti","54321123K","sueca","657849300",-6)));
        assertThrows(IllegalArgumentException.class, () -> p4.addMusico(new Musico(null,"Guidetti","78323145","francesa","678980989",9)));
        assertThrows(IllegalArgumentException.class, () -> p4.addGuionista(new Guionista("Carlos",null,"67582346J","espanhola","676543211",0,false)));
        assertThrows(IllegalArgumentException.class, () -> p4.addGuionista(new Guionista("Josep","Pedrerol",null,"espanhola","654321211",3,true)));
        assertThrows(IllegalArgumentException.class, () -> p4.addDoblador(new Doblador("Antonio","Sarosi","45678909J",null,"654343423",10)));
        assertThrows(IllegalArgumentException.class, () -> p4.addDoblador(new Doblador("Beta","Tech","65754321A","espanhola",null,7)));
        assertThrows(IllegalArgumentException.class, () -> p4.addInterprete(new Interprete("Martin","Outumuro","65489090X","espanhola","678980000",8,true,true,false)));
        assertThrows(IllegalArgumentException.class, () -> p4.addInterprete(new Interprete("Domingo","Iglesias","55566777K","espanhola","654789800",3,false,false,false)));
        assertThrows(IllegalArgumentException.class, () -> p4.addInterprete(new Interprete("Rosa Maria","Rodriguez","56766554T","espanhola","678998877",5,true,true,true)));
        assertThrows(IllegalArgumentException.class, () -> p4.addInterprete(new Interprete("Carla", "Iglesias","32111223M","espanhola","678984533",1,true,true,true)));
        assertThrows(IllegalArgumentException.class, () -> p4.addInterprete(new Interprete("Andres","Iglesias","12345678K","espanhola","654321099",33,false,true,true)));
        assertThrows(IllegalArgumentException.class, () -> p4.addEspecialista(new Especialista(null,null,null,null,null,-1,true)));
    }
}