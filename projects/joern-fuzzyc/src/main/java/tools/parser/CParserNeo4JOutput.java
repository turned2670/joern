package tools.parser;

import java.nio.file.Path;

import languages.c.parsing.Modules.ANTLRCModuleParserDriver;
import outputModules.neo4j.ParserNeo4JOutput;
import parsing.ModuleParser;

class CParserNeo4JOuput extends ParserNeo4JOutput
{

	ANTLRCModuleParserDriver driver = new ANTLRCModuleParserDriver();
	ModuleParser parser = new ModuleParser(driver);

	@Override
	public void visitFile(Path pathToFile)
	{
		dirTreeImporter.enterFile(pathToFile);
		parser.parseFile(pathToFile.toString());
	}

	@Override
	public void initialize()
	{
		super.initialize();
		parser.addObserver(astWalker);
	}


}