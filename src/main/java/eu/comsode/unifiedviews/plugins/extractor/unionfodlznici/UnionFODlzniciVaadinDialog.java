package eu.comsode.unifiedviews.plugins.extractor.unionfodlznici;

import eu.unifiedviews.dpu.config.DPUConfigException;
import eu.unifiedviews.helpers.dpu.vaadin.dialog.AbstractDialog;

public class UnionFODlzniciVaadinDialog extends AbstractDialog<UnionFODlzniciConfig_V1> {

    /**
     * 
     */
    private static final long serialVersionUID = -1539890500190668001L;

    public UnionFODlzniciVaadinDialog() {
        super(UnionFODlznici.class);
    }

    @Override
    protected void buildDialogLayout() {
    }

    @Override
    protected void setConfiguration(UnionFODlzniciConfig_V1 c) throws DPUConfigException {
    }

    @Override
    protected UnionFODlzniciConfig_V1 getConfiguration() throws DPUConfigException {

        final UnionFODlzniciConfig_V1 cnf = new UnionFODlzniciConfig_V1();
        return cnf;
    }

}
