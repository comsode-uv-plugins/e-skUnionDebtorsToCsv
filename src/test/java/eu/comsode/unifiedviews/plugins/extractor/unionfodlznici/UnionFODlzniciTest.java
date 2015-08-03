package eu.comsode.unifiedviews.plugins.extractor.unionfodlznici;

import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;
import cz.cuni.mff.xrg.odcs.dpu.test.TestEnvironment;
import eu.unifiedviews.dataunit.files.WritableFilesDataUnit;
import eu.unifiedviews.helpers.dpu.test.config.ConfigurationBuilder;

public class UnionFODlzniciTest {

	@Test
	public void execute() throws Exception {

		// Prepare config.
		UnionFODlzniciConfig_V1 config = new UnionFODlzniciConfig_V1();

		UnionFODlznici dpu = new UnionFODlznici();
		// Prepare DPU.
		dpu.configure((new ConfigurationBuilder()).setDpuConfiguration(config)
				.toString());

		// Prepare test environment.
		TestEnvironment environment = new TestEnvironment();

        // Prepare data unit.
        WritableFilesDataUnit filesOutput = environment
                .createFilesOutput("fileOutput");
		try {
			// Run.
			environment.run(dpu);
		} finally {
			// Release resources.
			environment.release();
		}
        assertTrue(readCSV());
	}

    private boolean readCSV() {
        final String fileName = "union_fo_dlznici.csv";
        final int COLUMNS = 8;
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row.length != COLUMNS) {
                    reader.close();
                    return false;
                }
            }
            reader.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
