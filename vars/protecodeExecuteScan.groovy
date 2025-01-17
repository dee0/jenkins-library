import groovy.transform.Field

import static com.sap.piper.Prerequisites.checkScript

@Field String STEP_NAME = getClass().getName()
@Field String METADATA_FILE = 'metadata/dee0-protecode.yaml'

//Metadata maintained in file project://resources/metadata/dee0-protecode.yaml

void call(Map parameters = [:]) {
    final script = checkScript(this, parameters) ?: this

    List credentials = [
        [type: 'usernamePassword', id: 'protecodeCredentialsId', env: ['PIPER_username', 'PIPER_password']],
        [type: 'file', id: 'dockerConfigJsonCredentialsId', env: ['PIPER_dockerConfigJSON']],
    ]
    piperExecuteBin(parameters, STEP_NAME, METADATA_FILE, credentials)
}
