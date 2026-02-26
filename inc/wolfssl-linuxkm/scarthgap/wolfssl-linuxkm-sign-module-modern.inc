# Sign libwolfssl.ko with the kernel's own signing key to prevent
# "module verification failed: signature and/or required key missing" taint on load.

do_install:append() {
    KO="${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/libwolfssl.ko"
    SIGN_FILE="${STAGING_KERNEL_BUILDDIR}/scripts/sign-file"
    KEY="${STAGING_KERNEL_BUILDDIR}/certs/signing_key.pem"
    CERT="${STAGING_KERNEL_BUILDDIR}/certs/signing_key.x509"

    if [ -x "${SIGN_FILE}" ] && [ -f "${KEY}" ] && [ -f "${CERT}" ]; then
        bbnote "Signing libwolfssl.ko with kernel signing key"
        "${SIGN_FILE}" sha256 "${KEY}" "${CERT}" "${KO}"
    else
        bbwarn "Kernel signing key not found - libwolfssl.ko will taint the kernel on load"
    fi
}
