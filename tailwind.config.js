module.exports = {
  content: ['./src/main/webapp/**/*.{html,jsp,jspf}'],
  theme: {
    extend: {
      colors: {
        ink: '#18332f',
        muted: '#64736f',
        canvas: '#f5f7f2',
        line: '#dce5df',
        teal: '#087e72',
        'teal-dark': '#06665d',
        coral: '#ed7059',
        citrus: '#d8e86c'
      },
      fontFamily: {
        sans: ['Trebuchet MS', 'Segoe UI', 'sans-serif'],
        display: ['Georgia', 'serif']
      },
      boxShadow: {
        lift: '0 18px 48px rgba(24, 51, 47, 0.12)'
      },
      keyframes: {
        'fade-up': {
          '0%': { opacity: '0', transform: 'translateY(12px)' },
          '100%': { opacity: '1', transform: 'translateY(0)' }
        }
      },
      animation: {
        'fade-up': 'fade-up 500ms ease-out both'
      }
    }
  },
  plugins: []
};