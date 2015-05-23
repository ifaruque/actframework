package org.osgl.oms.di.guice;

import org.osgl.oms.app.AppSourceCodeScannerBase;

class GuiceSourceCodeSensor extends AppSourceCodeScannerBase {

    private static final String GUICE_PKG = "com.google.inject";
    private static final String MODULE = "AbstractModule";

    private boolean pkgFound = false;
    private boolean moduleFound = false;

    @Override
    protected void _visit(int lineNumber, String line, String className) {
        if (!pkgFound) {
            if (line.contains(GUICE_PKG)) {
                pkgFound = true;
            }
        }
        if (pkgFound) {
            moduleFound = line.contains(MODULE);
            if (moduleFound) {
                markScanByteCode();
            }
        }
    }

    @Override
    protected boolean shouldScan(String className) {
        return true;
    }
}