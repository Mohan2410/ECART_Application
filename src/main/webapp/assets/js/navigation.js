(function () {
  var toggle = document.querySelector('[data-menu-toggle]');
  var menu = document.querySelector('[data-mobile-menu]');

  document.querySelectorAll('[data-password-toggle]').forEach(function (button) {
    button.addEventListener('click', function () {
      var field = document.getElementById(button.getAttribute('data-password-toggle'));
      if (!field) return;
      var visible = field.type === 'password';
      field.type = visible ? 'text' : 'password';
      var icon = button.querySelector('i');
      var label = button.querySelector('.sr-only');
      if (icon) icon.className = visible ? 'bi bi-eye-slash' : 'bi bi-eye';
      if (label) label.textContent = visible ? 'Hide password' : 'Show password';
      else button.textContent = visible ? 'Hide' : 'Show';
      button.setAttribute('aria-label', visible ? 'Hide password' : 'Show password');
    });
  });

  var password = document.querySelector('[data-password-policy]');
  var registrationForm = password ? password.form : null;
  if (password && registrationForm) {
    var passwordPattern = /^(?=.*[A-Z])(?=.*[^A-Za-z0-9\s])\S{8,}$/;
    var passwordRules = registrationForm.querySelectorAll('[data-password-rule]');

    function updatePasswordValidation() {
      var value = password.value;
      var satisfied = {
        length: value.length >= 8,
        uppercase: /[A-Z]/.test(value),
        special: /[^A-Za-z0-9\s]/.test(value),
        'no-space': value.length > 0 && !/\s/.test(value)
      };
      var message = '';

      passwordRules.forEach(function (item) {
        var valid = value.length > 0 && satisfied[item.getAttribute('data-password-rule')];
        var icon = item.querySelector('i');
        item.classList.toggle('text-teal', valid);
        item.classList.toggle('text-coral', !valid);
        if (icon) icon.className = valid ? 'bi bi-check-circle-fill mr-2' : 'bi bi-circle mr-2';
      });

      if (value && !passwordPattern.test(value)) {
        if (value.length < 8) message = 'Password must contain at least 8 characters.';
        else if (!/[A-Z]/.test(value)) message = 'Password must contain at least one uppercase letter.';
        else if (!/[^A-Za-z0-9\s]/.test(value)) message = 'Password must contain at least one special character.';
        else message = 'Password must not contain spaces.';
      }
      password.setCustomValidity(message);
      password.setAttribute('aria-invalid', message ? 'true' : 'false');
    }

    password.addEventListener('input', updatePasswordValidation);
    registrationForm.addEventListener('submit', updatePasswordValidation);
    updatePasswordValidation();
  }

  var mobile = document.querySelector('[data-mobile-validation]');
  if (mobile) {
    var mobileMessage = document.getElementById('mobile-guidance');
    function updateMobileValidation() {
      var invalid = mobile.value.length > 0 && !/^[0-9]{10}$/.test(mobile.value);
      if (mobileMessage) {
        mobileMessage.hidden = !invalid;
        mobileMessage.classList.toggle('hidden', !invalid);
      }
      mobile.setCustomValidity(invalid ? 'Mobile number must contain exactly 10 digits.' : '');
      mobile.setAttribute('aria-invalid', invalid ? 'true' : 'false');
    }
    mobile.addEventListener('input', updateMobileValidation);
    if (mobile.form) mobile.form.addEventListener('submit', updateMobileValidation);
    updateMobileValidation();
  }

  var email = document.querySelector('#cmailid[type="email"]');
  if (email) {
    var emailMessage = document.getElementById('email-guidance');
    function updateEmailValidation() {
      var invalid = email.value.length > 0 && email.validity.typeMismatch;
      if (emailMessage) {
        emailMessage.hidden = !invalid;
        emailMessage.classList.toggle('hidden', !invalid);
      }
      email.setCustomValidity(invalid ? 'Enter a valid email address.' : '');
      email.setAttribute('aria-invalid', invalid ? 'true' : 'false');
    }
    email.addEventListener('input', updateEmailValidation);
    if (email.form) email.form.addEventListener('submit', updateEmailValidation);
    updateEmailValidation();
  }

  document.querySelectorAll('form[data-disable-on-submit]').forEach(function (form) {
    form.addEventListener('submit', function (event) {
      if (event.defaultPrevented) return;
      var submitButton = form.querySelector('button[type="submit"]');
      if (submitButton) {
        submitButton.disabled = true;
        submitButton.setAttribute('aria-busy', 'true');
      }
    });
  });

  if (!toggle || !menu) return;

  function setOpen(open) {
    toggle.setAttribute('aria-expanded', String(open));
    toggle.setAttribute('aria-label', open ? 'Close navigation' : 'Open navigation');
    var menuIcon = toggle.querySelector('i');
    if (menuIcon) menuIcon.className = open ? 'bi bi-x-lg text-xl' : 'bi bi-list text-xl';
    menu.hidden = !open;
    menu.classList.toggle('hidden', !open);
    document.body.style.overflow = open && window.innerWidth < 768 ? 'hidden' : '';
  }

  toggle.addEventListener('click', function () {
    setOpen(toggle.getAttribute('aria-expanded') !== 'true');
  });

  menu.addEventListener('click', function (event) {
    if (event.target.closest('a')) setOpen(false);
  });

  document.addEventListener('keydown', function (event) {
    if (event.key === 'Escape' && toggle.getAttribute('aria-expanded') === 'true') {
      setOpen(false);
      toggle.focus();
    }
  });

  window.addEventListener('resize', function () {
    if (window.innerWidth >= 768) setOpen(false);
  });

})();