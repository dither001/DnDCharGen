package com.dnd5e.characters;

import com.miscellaneous.util.*;

public abstract class CharacterName {

	/*
	 * STATIC FIELDS
	 * 
	 */
	private static final String[] DRAGONBORN_FEMALE = { "AKRA", "AASATHRA", "ANTRARA", "ARAVA", "BIRI", "BLENDAETH",
			"BURANA", "CHASSATH", "DAAR", "DENTRATHA", "DOUDRA", "DRIINDAR", "EGGREN", "FARIDEH", "FINDEX", "FURRELE",
			"GESRETHE", "GILKASS", "HARANN", "HAVILAR", "HETHRESS", "HILLANOT", "JAXI", "JEZEAN", "JHERI", "KADANA",
			"KAVA", "KORINN", "MEGREN", "MIJIRA", "MISHANN", "NALA", "NUTHRA", "PERRA", "POGRNIX", "PYXRIN", "QUESPA",
			"RAIANN", "REZENA", "RULOTH", "SAPHARA", "SAVARAN", "SORA", "SURINA", "SYNTHRIN", "TATYAN", "THAVA",
			"UADJIT", "VEZERA", "ZYKROFF" };
	private static final String[] DRAGONBORN_MALE = { "ADREZ", "ARJHAN", "AZZAKH", "BALASAR", "BARADAD", "BHARASH",
			"BIDREKED", "DADALAN", "DAZZAZN", "DIRECRIS", "DONAAR", "FAX", "GARGAX", "GHESH", "GORBUNDUS", "GREETHEN",
			"HESKAN", "HIRRATHAK", "IDREX", "KALADAN", "KERKAD", "KIIRITH", "KRIV", "MAAGOG", "MEDRASH", "MEHEN",
			"MOZIKTH", "MREKSH", "MUGRUNDEN", "NADARR", "NITHTHER", "NORTKRUUTH", "NYKKAN", "PANJED", "PATRIN",
			"PIJJRIK", "QUARETHON", "RATHKRAN", "RHOGAR", "RIVAAN", "SETHREKAR", "SHAMASH", "SHEDINN", "SRORTHEN",
			"TARHUN", "TORINN", "TRYNNICUS", "VALOREAN", "VRONDISS", "ZENDAAR" };
	private static final String[] DWARF_FEMALE = { "ANBERA", "ARTIN", "AUDHILD", "BALIFRA", "BARBENA", "BARDRYN",
			"BOLHILD", "DAGNAL", "DARIFF", "DELRE", "DIESA", "ELDETH", "ERIDRED", "FALKRUNN", "FALLTHRA", "FINELLEN",
			"GILLYDD", "GUNNLODA", "GURDIS", "HELGRET", "HELJA", "HLIN", "ILDE", "JARANA", "KATHRA", "KILIA",
			"KRISTRYD", "LIFTRASA", "MARASTYR", "MARDRED", "MORANA", "NALAED", "NORA", "NURKANA", "ORIFF", "OVINA",
			"RISWYNN", "SANNL", "THERLIN", "THODRIS", "TORBERA", "TORDRID", "TORGGA", "URSHAR", "VALIDA", "VISTRA",
			"VONANA", "WERYDD", "WHURDRED", "YURGUNN" };
	private static final String[] DWARF_MALE = { "ADRIK", "ALBERICH", "BAERN", "BARENDD", "BELORIL", "BROTTOR", "DAIN",
			"DALGAL", "DARRAK", "DELG", "DUERGATH", "DWORIC", "EBERK", "EINKIL", "ELAIM", "ERIAS", "FALLOND", "FARGRIM",
			"GARDAIN", "GILTHUR", "GIMGEN", "GIMURT", "HARBEK", "KILDRAK", "KILVAR", "MORGRAN", "MORKRAL", "NALRAL",
			"NORDAK", "NURAVAL", "OLORIC", "OLUNT", "ORSIK", "OSKAR", "RANGRIM", "REIRAK", "RURIK", "TAKLINN",
			"THORADIN", "THORIN", "THRADAL", "TORDEK", "TRAUBON", "TRAVOK", "ULFGAR", "URAIM", "VEIT", "VONBIN",
			"VONDAL", "WHURBIN" };
	private static final String[] ELF_FEMALE = { "ADRIE", "AHINAR", "ALTHAEA", "ANASTRIANNA", "ANDRASTE", "ANTINUA",
			"ARARA", "BAELITAE", "BETHRYNNA", "BIREL", "CAELYNN", "CHAEDI", "CLAIRA", "DARA", "DRUSILA", "ELAMA",
			"ENNA", "FARAL", "FELOSIAL", "HATAE", "IELENIA", "ILANIS", "IRANN", "JARSALI", "JELENNETH", "KEYLETH",
			"LSHANNA", "LIA", "MAIATHAH", "MALQUIS", "MERIELE", "MIALEE", "MYATHETHIL", "NAIVARA", "QUELENNA",
			"QUILLATHE", "RIDARO", "SARIEL", "SHANAIRLA", "SHAVA", "SILAQUI", "SUMNES", "THEIRASTRA", "THIALA",
			"TIAATHQUE", "TRAUMLAM", "VADANIA", "VALANTHE", "VALNA", "XANAPHIA" };
	private static final String[] ELF_MALE = { "ADRAN", "AELAR", "AERDETH", "AHVAIN", "ARAMIL", "ARANNIS", "AUST",
			"AZAKI", "BEIRO", "BERRIAN", "CAELDRIM", "CARRIC", "DAYERETH", "DREALI", "EFFERIL", "EIRAVEL", "ENIALIS",
			"ERDAN", "EREVAN", "FIVIN", "GALINNDAN", "GENNAL", "HADARAI", "HALIMATH", "HEIAN", "HIMO", "IMMERAL",
			"IVELLIOS", "KORFEL", "LAMLIS", "LAUCIAN", "LUCAN", "MINDARTIS", "NAAL", "NUTAE", "PAELIAS", "PEREN",
			"QUARION", "RIARDON", "ROLEN", "SOVELISS", "SUHNAE", "THAMIOR", "THARIVOL", "THEREN", "THERIASTIS",
			"THERVAN", "UTHEMAR", "VANUATH", "VARIS" };
	private static final String[] GNOME_FEMALE = { "ABALABA", "BIMPNOTTIN", "BREENA", "BUVVIE", "CALLYBON", "CARAMIP",
			"CARLIN", "CUMPEN", "DALABA", "DONELLA", "DUVAMIL", "ELLA", "ELLYJOYBELL", "ELLYWICK", "ENIDDA", "LILLI",
			"LOOPMOTTIN", "LORILLA", "LUTHRA", "MARDNAB", "MEENA", "MENNY", "MUMPENA", "NISSA", "NUMBA", "NYX", "ODA",
			"OPPAH", "ORLA", "PANANA", "PYNTLE", "QUILLA", "RANALA", "REDDLEPOP", "ROYWYN", "SALANOP", "SHAMIL",
			"SIFFRESS", "SYMMA", "TANA", "TENENA", "TERVAROUND", "TIPPLETOE", "ULLA", "UNVERA", "VELOPTIMA", "VIRRA",
			"WAYWOCKET", "YEBE", "ZANNA" };
	private static final String[] GNOME_MALE = { "ALSTON", "ALVYN", "ANVERTH", "ARUMAWANN", "BILBRON", "BODDYNOCK",
			"BROCC", "BURGELL", "COCKABY", "CRAMPERNAP", "DABBLEDOB", "DLEBEAN", "DIMBLE", "EBERDEB", "ELDON", "ERKY",
			"FABLEN", "FIBBLESTIB", "FONKIN", "FROUSE", "FRUG", "GERBO", "GIMBLE", "GLIM", "IGDEN", "JABBLE", "JEBEDDO",
			"KELLEN", "KIPPER", "NAMFOODLE", "OPPLEBY", "ORRYN", "PAGGEN", "PALLABAR", "POG", "QUALEN", "RIBBLES",
			"RIMPLE", "ROONDAR", "SAPPLY", "SEEBO", "SENTEQ", "SINDRI", "UMPEN", "WARRYN", "WIGGENS", "WOBBLES",
			"WRENN", "ZAFFRAB", "ZOOK" };
	private static final String[] HALFLING_FEMALE = { "ALAIN", "ANDRY", "ANNE", "BELLA", "BLOSSOM", "BREE", "CALLIE",
			"CHENNA", "CORA", "DEE", "DELL", "EIDA", "ERAN", "EUPHEMIA", "GEORGINA", "GYNNIE", "HARRIET", "JASMINE",
			"JILLIAN", "JO", "KITHRI", "LAVINIA", "LIDDA", "MAEGAN", "MARIGOLD", "MERLA", "MYRIA", "NEDDA", "NIKKI",
			"NORA", "OLIVIA", "PAELA", "PEARL", "PENNIE", "PHILOMENA", "PORTIA", "ROBBIE", "ROSE", "SARAL", "SERAPHINA",
			"SHAENA", "STACEE", "TAWNA", "THEA", "TRYM", "TYNA", "VANI", "VERNA", "WELLA", "WILLOW" };
	private static final String[] HALFLING_MALE = { "ALTON", "ANDER", "BERNIE", "BOBBIN", "CADE", "CALLUS", "CORRIN",
			"DANNAD", "DANNIEL", "EDDIE", "EGART", "ELDON", "ERRICH", "FILDO", "FINNAN", "FRANKLIN", "GARRET", "GARTH",
			"GILBERT", "GOB", "HAROL", "IGOR", "JASPER", "KEITH", "KEVIN", "LAZAM", "LERRY", "LINDAL", "LYLE", "MERRIC",
			"MICAN", "MILO", "MORRIN", "NEBIN", "NEVIL", "OSBORN", "OSTRAN", "OSWALT", "PERRIN", "POPPY", "REED",
			"ROSCOE", "SAM", "SHARDON", "TYE", "ULMO", "WELLBY", "WENDEL", "WENNER", "WES" };
	private static final String[] HALF_ORC_FEMALE = { "ARHA", "BAGGI", "BENDOO", "BILGA", "BRAKKA", "CREEGA", "DRENNA",
			"EKK", "EMEN", "ENGOING", "FISTULA", "GAAKI", "GORGA", "GRAI", "GREEBA", "GRIGI", "GYNK", "HRATHY", "HURU",
			"ILGA", "KABBARG", "KANSIF", "LAGAZI", "LEZRE", "MURGEN", "MURDOOK", "MYEV", "NAGRETTE", "NEEGA", "NELLA",
			"NOGU", "OOLAH", "OOTAH", "OVAK", "OWNKA", "PUYET", "REEZA", "SHAUTHA", "SILGRE", "SUTHA", "TAGGA", "TAWAR",
			"TOMPH", "UBADA", "VANCHU", "VOLA", "VOLEN", "VORKA", "YEVELDA", "ZAGGA" };
	private static final String[] HALF_ORC_MALE = { "ARGRAN", "BRAAK", "BRUG", "CAGAK", "DENCH", "DORN", "DREN",
			"DRUUK", "FENG", "GELL", "GNARSH", "GRUMBAR", "GUBRASH", "HAGREN", "HENK", "HOGAR", "HOLG", "IMSH",
			"KARASH", "KARG", "KETH", "KORAG", "KRUSK", "LUBASH", "MEGGED", "MHURREN", "MORD", "MORG", "NIL", "NYBARG",
			"ODORR", "OHR", "RENDAR", "RESH", "RONT", "RRATH", "SARK", "SCRAG", "SHEGGEN", "SHUMP", "TANGLAR", "TARAK",
			"THAR", "THOKK", "TRAG", "UGARTH", "VARG", "VILBERG", "YURK", "ZED" };
	private static final String[] TIEFLING_FEMALE = { "AKTA", "ANAKIS", "ARMARA", "ASTARO", "AYM", "AZZA", "BELETH",
			"BRYSEIS", "BUNE", "CRIELLA", "DAMAIA", "DECARABIA", "EA", "GADREEL", "GOMORY", "HECAT", "ISHTE",
			"JEZEBETH", "KALI", "KALLISTA", "KASDEYA", "LERISSA", "LILITH", "MAKARIA", "MANEA", "MARKOSIAN", "MASTEMA",
			"NAAMAH", "NEMEIA", "NIJA", "ORIANNA", "OSAH", "PHELAIA", "PROSPERINE", "PURAH", "PYRA", "RIETA", "RONOBE",
			"RONWE", "SEDDIT", "SEERE", "SEKHMET", "SEMYAZA", "SHAVA", "SHAX", "SORATH", "UZZA", "VAPULA", "VEPAR",
			"VERIN" };
	private static final String[] TIEFLING_MALE = { "ABAD", "AHRIM", "AKMEN", "AMNON", "ANDRAM", "ASTAR", "BALAM",
			"BARAKAS", "BATHIN", "CAIM", "CHEM", "CIMER", "CRESSEL", "DAMAKOS", "EKEMON", "EURON", "FENRIZ", "FORCAS",
			"HABOR", "IADOS", "KAIRON", "LEUCIS", "MAMNEN", "MANTUS", "MARBAS", "MELECH", "MERIHIM", "MODEAN", "MORDAI",
			"MORMO", "MORTHOS", "NICOR", "NIRGEL", "ORIAX", "PAYMON", "PELAIOS", "PURSON", "QEMUEL", "RAAM", "RIMMON",
			"SAMMAL", "SKAMOS", "TETHREN", "THAMUZ", "THERAI", "VALAFAR", "VASSAGO", "XAPPAN", "ZEPAR", "ZEPHAN" };

	/*
	 * HUMAN NAMES
	 */
	private static final String[] ENGLISH_FEMALE = { "ADELAIDE", "AGATHA", "AGNES", "ALICE", "ALINE", "ANNE", "AVELINA",
			"AVICE", "BEATRICE", "CECILY", "EGELINA", "ELEANOR", "ELIZABETH", "ELLA", "ELOISE", "ELYSANDE", "EMENY",
			"EMMA", "EMMELINE", "ERMINA", "EVA", "GALIENA", "GEVA", "GISELLE", "GRISELDA", "HADWISA", "HELEN",
			"HERLEVA", "HUGOLINA", "IDA", "ISABELLA", "JACOBA", "JANE", "JOAN", "JULIANA", "KATHERINE", "MARGERY",
			"MARY", "MATILDA", "MAYNILD", "MILICENT", "ORIEL", "ROHESIA", "ROSALIND", "ROSAMUND", "SARAH", "SUSANNAH",
			"SYBIL", "WILLIAMINA", "YVONNE" };
	private static final String[] ENGLISH_MALE = { "ADAM", "ADELARD", "ALDOUS", "ANSELM", "ARNOLD", "BERNARD",
			"BERTRAM", "CHARLES", "CLEREBOLD", "CONRAD", "DIGGORY", "DROGO", "EVERARD", "FREDERICK", "GEOFFREY",
			"GERALD", "GILBERT", "GODFREY", "GUNTER", "GUY", "HENRY", "HEWARD", "HUBERT", "HUGH", "JOCELYN", "JOHN",
			"LANCE", "MANFRED", "MILES", "NICHOLAS", "NORMAN", "ODO", "PERCIVAL", "PETER", "RALF", "RANDAL", "RAYMOND",
			"REYNARD", "RICHARD", "ROBERT", "ROGER", "ROLAND", "ROLF", "SIMON", "THEOBALD", "THEODORIC", "THOMAS",
			"TIMM", "WILLIAM", "WYMAR" };

	/*
	 * STATIC METHODS
	 */
	public static String randomName(boolean isFemale, Race race) {
		String[] array = null;

		switch (race) {
		case DARK_ELF:
		case HIGH_ELF:
		case WOOD_ELF:
			array = (isFemale) ? ELF_FEMALE : ELF_MALE;
			break;
		case REDSCALE:
		case BLACKSCALE:
		case BLUESCALE:
		case GREENSCALE:
		case WHITESCALE:
		case GOLDLEAF:
		case SILVERLEAF:
		case BRONZELEAF:
		case BRASSLEAF:
		case COPPERLEAF:
			array = (isFemale) ? DRAGONBORN_FEMALE : DRAGONBORN_MALE;
			break;
		case FOREST_GNOME:
		case ROCK_GNOME:
			array = (isFemale) ? GNOME_FEMALE : GNOME_MALE;
			break;
		case HALF_ORC:
			array = (isFemale) ? HALF_ORC_FEMALE : HALF_ORC_MALE;
			break;
		case HILL_DWARF:
		case MOUNTAIN_DWARF:
			array = (isFemale) ? DWARF_FEMALE : DWARF_MALE;
			break;
		case HALF_ELF:
		case HUMAN:
			array = (isFemale) ? ENGLISH_FEMALE : ENGLISH_MALE;
			break;
		case LIGHTFOOT_HALFLING:
		case STRONGHEART_HALFLING:
			array = (isFemale) ? HALFLING_FEMALE : HALFLING_MALE;
			break;
		case TIEFLING:
			array = (isFemale) ? TIEFLING_FEMALE : TIEFLING_MALE;
			break;
		default:
			array = (isFemale) ? ENGLISH_FEMALE : ENGLISH_MALE;
			break;
		}

		return Misc.randomFromArray(array);
	}

}
