import kz.epam.xml_xsd_parsing.entity.*;
import kz.epam.xml_xsd_parsing.validator.ValidatorXML;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

//TestNG framework
public class XMLTests {
	private final static String XML_FILE_NAME = "Bank.xml";
	private final static String XSD_FILE_NAME = "Bank.xsd";
	private final static String SAX = "sax";
	private final static String STAX = "stax";
	private final static String DOM = "dom";
	private final static int NUMBER_OF_BANKS = 16;

	//validates xml file using xsd file
	@BeforeMethod
	public void setUp() {
		assertTrue(ValidatorXML.validateXML(XML_FILE_NAME, XSD_FILE_NAME));
	}

	@Test
	public void testBanksSAXBuilder() {
		AbstractBanksBuilder builder = BankBuilderFactory.createBankBuilder(SAX);
		assertTrue(builder instanceof BanksSAXBuilder);
	}

	@Test
	public void testBanksSTAXBuilder() {
		AbstractBanksBuilder builder = BankBuilderFactory.createBankBuilder(STAX);
		assertTrue(builder instanceof BanksStAXBuilder);
	}

	@Test
	public void testBanksDOMBuilder() {
		AbstractBanksBuilder builder = BankBuilderFactory.createBankBuilder(DOM);
		assertTrue(builder instanceof BanksDOMBuilder);
	}

	@Test
	public void testBuildSetBanksForSAX() {
		BanksSAXBuilder builder = new BanksSAXBuilder();
		builder.buildSetBanks(XML_FILE_NAME);
		assertTrue(NUMBER_OF_BANKS == builder.getBanks().size());
	}

	@Test
	public void testBuildSetBanksForSTAX() {
		BanksStAXBuilder builder = new BanksStAXBuilder();
		builder.buildSetBanks(XML_FILE_NAME);
		assertTrue(NUMBER_OF_BANKS == builder.getBanks().size());
	}

	@Test
	public void testBuildSetBanksForDOM() {
		BanksDOMBuilder builder = new BanksDOMBuilder();
		builder.buildSetBanks(XML_FILE_NAME);
		assertTrue(NUMBER_OF_BANKS == builder.getBanks().size());
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testBankBuilderFactoryWithInvalidInput() {
		final String invalidInput = "Invalid Input";
		AbstractBanksBuilder builder = BankBuilderFactory.createBankBuilder(invalidInput);
	}


}
